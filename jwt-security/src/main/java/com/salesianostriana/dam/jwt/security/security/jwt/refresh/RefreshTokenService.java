package com.salesianostriana.dam.jwt.security.security.jwt.refresh;

import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    @Transactional
    public RefreshToken create(User user) {
        //User u = userRepository.findById(user.getId()).orElse(null);
        return refreshTokenRepository.save(
          RefreshToken.builder()
                  .user(user)
                  //.user(u)
                  .token(UUID.randomUUID().toString())
                  .expireAt(Instant.now().plusSeconds(durationInMinutes*60))
                  .build()
        );
    }


}
