package com.salesianostriana.dam.datamodel.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private String nombre, apellidos, email;

    private LocalDate fechaNacimiento;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Helpers
    public void addToCurso(Curso curso) {
        this.curso = curso;
        curso.getAlumnos().add(this);
    }

    public void removeFromCurso(Curso curso) {
        curso.getAlumnos().remove(this);
        this.curso = null;
    }


}