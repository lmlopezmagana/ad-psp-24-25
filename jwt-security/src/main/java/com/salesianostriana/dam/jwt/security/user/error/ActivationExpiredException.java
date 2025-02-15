package com.salesianostriana.dam.jwt.security.user.error;

public class ActivationExpiredException extends RuntimeException {
    public ActivationExpiredException(String s) {
        super(s);
    }
}
