package com.salesianostriana.dam.upload.files.utils;

import com.salesianostriana.dam.upload.files.exception.StorageException;
import org.apache.tika.Tika;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/*public class MediaTypeUrlResource extends UrlResource {
    public MediaTypeUrlResource(URL url) {
        super(url);
    }

    public MediaTypeUrlResource(URI uri) throws MalformedURLException {
        super(uri);
    }

    public MediaTypeUrlResource(String path) throws MalformedURLException {
        super(path);
    }

    public MediaTypeUrlResource(String protocol, String location) throws MalformedURLException {
        super(protocol, location);
    }

    public MediaTypeUrlResource(String protocol, String location, String fragment) throws MalformedURLException {
        super(protocol, location, fragment);
    }

    public String getType() {
        Tika t = new Tika();
        try {
            return t.detect(this.getFile());
        } catch (IOException ex) {
            throw new StorageException("Error trying to get the MIME type", ex);
        }
    }
}
*/
/*
package com.salesianostriana.dam.imageupload.upload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;
import java.util.Optional;

@Service
public class ImgurService {

    private final String clientId;
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://api.imgur.com/3/image";
    public static final String URL_NEW_IMAGE = BASE_URL;
    public static final String URL_DELETE_IMAGE = BASE_URL + "/{hash}";
    public static final String URL_GET_IMAGE = BASE_URL + "/{id}";
    public static final int SUCCESS_UPLOAD_STATUS = 200;
    public static final int SUCCESS_GET_STATUS = 200;d

    private UriBuilderFactory factory = new DefaultUriBuilderFactory();
    private static final Logger logger = LoggerFactory.getLogger(ImgurService.class);

    public ImgurService(@Value("${imgur.clientid}") String clientId) {
        this.clientId = clientId;
        this.restTemplate = new RestTemplate();

        this.restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||
                        response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR;
            }

            @Override
            public void handleError(URI url, HttpMethod method, ClientHttpResponse response) {
                switch (response.getStatusCode()) {
                    case INTERNAL_SERVER_ERROR:
                        throw new RuntimeException("Error de servidor");
                    case BAD_REQUEST:
                        throw new ImgurBadRequest();
                    case NOT_FOUND:
                        throw new ImgurImageNotFoundException();
                    default:
                        break;
                }
            }
        });
    }

    public Optional<NewImageRes> upload(NewImageReq imageReq) {
        HttpHeaders headers = getHeaders();
        HttpEntity<NewImageReq> request = new HttpEntity<>(imageReq, headers);

        NewImageRes imageRes = restTemplate.postForObject(URL_NEW_IMAGE, request, NewImageRes.class);

        if (imageRes != null && imageRes.getStatus() == SUCCESS_UPLOAD_STATUS) {
            return Optional.of(imageRes);
        }

        return Optional.empty();
    }

    public void delete(String hash) {
        logger.debug("Realizando la petición DELETE para eliminar la imagen " + hash);

        URI uri = factory.uriString(URL_DELETE_IMAGE).build(hash);
        RequestEntity<Void> request = RequestEntity.delete(uri).headers(getHeaders()).build();

        restTemplate.exchange(request, Void.class);
    }

    public Optional<GetImageRes> get(String id) {
        URI uri = factory.uriString(URL_GET_IMAGE).build(id);
        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .headers(getHeaders())
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<GetImageRes> response = restTemplate.exchange(request, GetImageRes.class);

        if (response.getStatusCode().is2xxSuccessful() && response.hasBody()) {
            return Optional.of(response.getBody());
        }

        return Optional.empty();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + clientId);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static class ImgurImageNotFoundException extends RuntimeException {
        public ImgurImageNotFoundException() {
            super("No se ha podido encontrar la imagen");
        }
    }

    public static class ImgurBadRequest extends RuntimeException {
        public ImgurBadRequest() {
            super("Error al realizar la petición");
        }
    }
}

 */