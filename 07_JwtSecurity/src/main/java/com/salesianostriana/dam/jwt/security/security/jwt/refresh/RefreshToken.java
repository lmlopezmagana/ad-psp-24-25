package com.salesianostriana.dam.jwt.security.security.jwt.refresh;

import com.salesianostriana.dam.jwt.security.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue
    private UUID id;

    //@MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*@NaturalId
    @Column(nullable = false, unique = true)
    private String token;
    */
    @Column(nullable = false)
    private Instant expireAt;

    @Builder.Default
    private Instant createdAt = Instant.now();

    public String getToken() {
        return id.toString();
    }

}
