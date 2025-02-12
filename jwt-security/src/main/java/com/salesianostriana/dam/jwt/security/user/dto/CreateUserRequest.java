package com.salesianostriana.dam.jwt.security.user.dto;

public record CreateUserRequest(
        String username, String password, String verifyPassword
) {
}
