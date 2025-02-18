package com.salesianostriana.dam.jwt.security.user.dto;

public record LoginRequest(
        String username, String password
) {
}
