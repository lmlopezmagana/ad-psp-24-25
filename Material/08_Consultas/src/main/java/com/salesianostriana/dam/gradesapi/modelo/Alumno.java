package com.salesianostriana.dam.gradesapi.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private LocalDate fechaNacimiento;

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    private Set<Asignatura> asignaturas = new HashSet<>();

}
