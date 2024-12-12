package com.salesianostriana.dam.database;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "propiedad_1")
    private String propiedad1;

    @Column(name = "propiedad_2")
    private Long propiedad2;


}