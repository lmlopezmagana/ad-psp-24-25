package com.salesianos.data.dto;

import com.salesianos.data.validation.FieldsValueMatch;
import com.salesianos.data.validation.UniqueUsername;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Los valores de password y verifyPassword no coinciden"),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "verifyEmail",
                message = "Los valores de email y verifyEmail no coinciden")
})
public record CreateUsuarioCmd(
        @UniqueUsername
        String username,
        String password,
        String verifyPassword,
        String email,
        String verifyEmail
) {
}
