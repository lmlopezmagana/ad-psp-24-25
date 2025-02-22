package com.salesianostriana.dam.upload.files.controller;

import com.salesianostriana.dam.upload.files.dto.FileResponse;
import com.salesianostriana.dam.upload.files.model.FileMetadata;
import com.salesianostriana.dam.upload.files.service.StorageService;
import com.salesianostriana.dam.upload.files.utils.MimeTypeDetector;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final StorageService storageService;
    private final MimeTypeDetector mimeTypeDetector;



    @PostMapping("/upload/files")
    public ResponseEntity<?> upload(@RequestPart("files") MultipartFile[] files) {


        List<FileResponse> result = Arrays.stream(files)
                .map(this::uploadFile)
                .toList();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file) {

        FileResponse response = uploadFile(file);

        return ResponseEntity.created(URI.create(response.uri())).body(response);
    }

    private FileResponse uploadFile(MultipartFile multipartFile) {
        FileMetadata fileMetadata = storageService.store(multipartFile);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileMetadata.getId())
                .toUriString();

        fileMetadata.setURL(uri);

        return FileResponse.builder()
                .id(fileMetadata.getId())
                .name(fileMetadata.getFilename())
                .size(multipartFile.getSize())
                .type(multipartFile.getContentType())
                .uri(uri)
                .build();
    }


    @GetMapping("/download/{id:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String id) {
        Resource resource = storageService.loadAsResource(id);

        String mimeType = mimeTypeDetector.getMimeType(resource);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", mimeType)
                .body(resource);
    }

}
