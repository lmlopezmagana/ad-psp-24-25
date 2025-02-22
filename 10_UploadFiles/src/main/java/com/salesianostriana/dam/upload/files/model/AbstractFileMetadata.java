package com.salesianostriana.dam.upload.files.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractFileMetadata implements FileMetadata {

    protected String id;
    protected String filename;
    protected String URL;
    protected String deleteId;
    protected String deleteURL;

}
