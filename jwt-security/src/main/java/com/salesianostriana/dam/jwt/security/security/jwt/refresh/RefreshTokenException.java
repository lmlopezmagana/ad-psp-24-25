package com.salesianostriana.dam.jwt.security.security.jwt.refresh;

import com.salesianostriana.dam.jwt.security.security.exceptionhandling.JwtException;

public class RefreshTokenException extends JwtException {
    public RefreshTokenException(String s) {
        super(s);
    }
}
