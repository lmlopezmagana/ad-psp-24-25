package com.salesianostriana.dam.upload.files.service.imgur;

import com.salesianostriana.dam.upload.files.exception.StorageException;
import com.salesianostriana.dam.upload.files.model.FileMetadata;
import com.salesianostriana.dam.upload.files.service.StorageService;
import com.salesianostriana.dam.upload.files.service.imgur.dto.GetImageResponse;
import com.salesianostriana.dam.upload.files.service.imgur.dto.NewImageRequest;
import com.salesianostriana.dam.upload.files.service.imgur.dto.NewImageResponse;
import com.salesianostriana.dam.upload.files.service.imgur.error.ImgurBadRequestException;
import com.salesianostriana.dam.upload.files.service.imgur.error.ImgurImageNotFoundException;
import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collections;

import static org.springframework.http.HttpStatus.*;

@Log
@Service
public class ImgurStorageService implements StorageService {

    private static final String BASE_URL = "https://api.imgur.com/3/image";
    public static final String URL_NEW_IMAGE = BASE_URL;
    public static final String URL_DELETE_IMAGE = BASE_URL + "/{hash}";
    public static final String URL_GET_IMAGE = BASE_URL + "/{id}";
    public static final int SUCCESS_UPLOAD_STATUS = 200;

    @Value("${imgur.clientid}")
    private String clientId;

    private RestTemplate restTemplate;
    private UriBuilderFactory uriBuilderFactory;


    @PostConstruct
    @Override
    public void init() {
        log.info("clientid %s".formatted(clientId));
        uriBuilderFactory = new DefaultUriBuilderFactory();
        restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return response.getStatusCode().is4xxClientError() ||
                        response.getStatusCode().is5xxServerError();
            }

            @Override
            public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
                HttpStatusCode statusCode = response.getStatusCode();
                if (statusCode.equals(INTERNAL_SERVER_ERROR)) {
                    throw new RuntimeException("Error de servidor");
                } else if (statusCode.equals(BAD_REQUEST)) {
                    throw new ImgurBadRequestException("Error en la solicitud de imagen");
                } else if (statusCode.equals(NOT_FOUND)) {
                    throw new ImgurImageNotFoundException("Imagen no encontrada");
                }
            }
        });


    }

    @Override
    public FileMetadata store(MultipartFile file) {

        if (file.isEmpty()) {
            throw new ImgurBadRequestException("Error en la solicitud. Fichero vacío");
        } else {
            try {
                NewImageRequest req = new NewImageRequest(
                        Base64.getEncoder().encodeToString(file.getBytes()),
                        file.getOriginalFilename()
                );

                HttpHeaders headers = getHeaders();
                HttpEntity<NewImageRequest> request =
                        new HttpEntity<>(req, headers);

                NewImageResponse response =
                        restTemplate.postForObject(
                                URL_NEW_IMAGE,
                                request,
                                NewImageResponse.class);

                if (response != null &&
                    response.status() == SUCCESS_UPLOAD_STATUS) {
                    return new ImgurFileMetadataImpl(
                            response.data().id(),
                            file.getOriginalFilename(),
                            uriBuilderFactory.uriString(URL_GET_IMAGE).build(response.data().id()).toString(),
                            response.data().deletehash(),
                            uriBuilderFactory.uriString(URL_DELETE_IMAGE).build(response.data().deletehash()).toString()
                            );
                } else {
                    throw new ImgurBadRequestException("Error en la solicitud. Error en la subida de imagen");
                }



            } catch (Exception e) {
                throw new ImgurBadRequestException(e.getMessage());
            }

        }


    }

    @Override
    public Resource loadAsResource(String id) {
        URI uri = uriBuilderFactory.uriString(URL_GET_IMAGE).build(id);
        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .headers(getHeaders())
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<GetImageResponse> responseEntity =
                restTemplate.exchange(request, GetImageResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.hasBody()) {
             GetImageResponse getImageResponse =
                     responseEntity.getBody();

            try {
                UrlResource resource =
                        new UrlResource(getImageResponse.data().link());

                if (resource.exists() && resource.isReadable()) {
                    return resource;
                } else {
                    throw new StorageException("Could not read file: " + getImageResponse.data().link());
                }

            } catch (MalformedURLException ex) {
                throw new StorageException("Could not read file: " + getImageResponse.data().link());
            }

        } else {
            throw new ImgurImageNotFoundException("No se ha encontrado la imagen con id %s".formatted(id));
        }
    }
    @Override
    public void deleteFile(String deleteHash) {
        URI uri = uriBuilderFactory.uriString(URL_DELETE_IMAGE).build(deleteHash);
        deleteByUrl(uri.toString());
    }

    public void deleteByUrl(String url) {
        URI uri = URI.create(url);
        RequestEntity<Void> request = RequestEntity.delete(uri).headers(getHeaders()).build();
        restTemplate.exchange(request, Void.class);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + clientId);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}


