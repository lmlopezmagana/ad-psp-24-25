package com.salesianostriana.dam.upload.files.service;

import com.salesianostriana.dam.upload.files.model.FileMetadata;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void init();

    FileMetadata store(MultipartFile file);

    Resource loadAsResource(String id);

    void deleteFile(String filename);


}
