package com.salesianostriana.dam.rest.dto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data // Jpa Buddy
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id @GeneratedValue
    private Long id;

    private String codigoPais, pais, ciudad,
            loc, nombre, descripcion;

    @ElementCollection // Obligatoria en Spring Boot 2.
    private List<String> imagenes;

    @ManyToOne
    private Categoria categoria;


}
