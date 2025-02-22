package com.salesianostriana.dam.upload.files.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record FileResponse(
    String name,
    String uri,
    String type,
    long size
    )
{}
