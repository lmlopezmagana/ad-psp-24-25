package com.salesianostriana.dam.upload.files.service.imgur.dto;

public record GetImageResponse(
        String success,
        int status,
        GetImageInfo data
) {
}
