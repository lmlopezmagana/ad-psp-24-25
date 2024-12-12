package com.salesianostriana.dam.rest.dto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private int tiempo; // en minutos

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @ManyToMany
    private List<Monumento> monumentos;

}
