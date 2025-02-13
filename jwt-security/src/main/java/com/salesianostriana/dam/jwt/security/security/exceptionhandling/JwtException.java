package com.salesianostriana.dam.jwt.security.security.exceptionhandling;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
