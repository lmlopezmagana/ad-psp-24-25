package com.salesianostriana.dam.upload.files.service.local;

import com.salesianostriana.dam.upload.files.model.AbstractFileMetadata;
import com.salesianostriana.dam.upload.files.model.FileMetadata;
import lombok.experimental.SuperBuilder;


@SuperBuilder
public class LocalFileMetadataImpl extends AbstractFileMetadata {

    public static FileMetadata of(String filename) {
        return LocalFileMetadataImpl.builder()
                .id(filename)
                .filename(filename)
                .build();
    }

}
