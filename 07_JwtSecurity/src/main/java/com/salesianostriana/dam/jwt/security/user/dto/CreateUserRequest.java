package com.salesianostriana.dam.jwt.security.user.dto;

public record CreateUserRequest(
        String username, String email, String password, String verifyPassword
) {
}
