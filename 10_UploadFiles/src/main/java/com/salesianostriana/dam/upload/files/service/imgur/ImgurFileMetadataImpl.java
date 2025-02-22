package com.salesianostriana.dam.upload.files.service.imgur;

import com.salesianostriana.dam.upload.files.model.AbstractFileMetadata;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ImgurFileMetadataImpl extends AbstractFileMetadata {

    public ImgurFileMetadataImpl(String id, String filename, String URL, String deleteId, String deleteURL) {
        super(id, filename, URL, deleteId, deleteURL);
    }
}
