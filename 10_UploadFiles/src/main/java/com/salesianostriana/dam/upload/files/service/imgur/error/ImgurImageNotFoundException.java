package com.salesianostriana.dam.upload.files.service.imgur.error;

public class ImgurImageNotFoundException extends RuntimeException {
    public ImgurImageNotFoundException(String message) {
        super(message);
    }
}
