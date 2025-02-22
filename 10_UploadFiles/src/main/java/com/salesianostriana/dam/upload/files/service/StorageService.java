package com.salesianostriana.dam.upload.files.service;

import com.salesianostriana.dam.upload.files.model.FileMetadata;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    FileMetadata store(MultipartFile file);

    Resource loadAsResource(String filename);

    void deleteFile(String filename);


}
