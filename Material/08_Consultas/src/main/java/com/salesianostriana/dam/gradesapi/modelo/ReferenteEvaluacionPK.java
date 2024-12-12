package com.salesianostriana.dam.gradesapi.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ReferenteEvaluacionPK implements Serializable {

    private Asignatura asignatura;

    private String codReferente;

    private ReferenteEvaluacionPK() {}

}
