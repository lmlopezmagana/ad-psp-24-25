package com.salesianostriana.dam.datamodel.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "curso")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre, tutor;


    @ToString.Exclude
    @OneToMany(mappedBy = "curso")
    @Builder.Default
    private List<Alumno> alumnos = new ArrayList<>();

}