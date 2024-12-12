package com.salesianostriana.dam.gradesapi.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Calificacion {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Instrumento instrumento;

    @ManyToOne
    private ReferenteEvaluacion referente;

    @ManyToOne
    private Alumno alumno;

    private double calificacion;



}
