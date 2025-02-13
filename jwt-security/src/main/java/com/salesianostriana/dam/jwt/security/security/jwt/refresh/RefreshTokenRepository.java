package com.salesianostriana.dam.jwt.security.security.jwt.refresh;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository
    extends JpaRepository<RefreshToken, UUID> {

    Optional<RefreshToken> findByToken(String token);

}
