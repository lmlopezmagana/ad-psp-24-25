package com.salesianostriana.dam.upload.files.service.imgur.dto;

public record NewImageInfo(
        String link,
        String id,
        String deletehash
) {
}
