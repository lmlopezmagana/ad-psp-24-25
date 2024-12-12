package com.salesianostriana.dam.gradesapi.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrumento {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private LocalDateTime fecha;

    private String contenidos;

    @ManyToOne
    private Asignatura asignatura;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ReferenteEvaluacion> referentes = new HashSet<>();

}
