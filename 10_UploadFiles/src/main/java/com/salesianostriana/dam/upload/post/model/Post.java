package com.salesianostriana.dam.upload.post.model;


import lombok.*;

import jakarta.persistence.*;


@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String image;


}
