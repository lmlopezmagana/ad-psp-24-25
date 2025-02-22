package com.salesianostriana.dam.upload.files.service.imgur.dto;

public record NewImageResponse(
        String success,
        int status,
        NewImageInfo data
) {
}
