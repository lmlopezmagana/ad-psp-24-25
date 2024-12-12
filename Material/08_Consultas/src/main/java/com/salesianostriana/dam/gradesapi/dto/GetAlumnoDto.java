package com.salesianostriana.dam.gradesapi.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.gradesapi.modelo.Alumno;

public record GetAlumnoDto(
        Long id,
        String nombre,
        int cantidadAsignaturas,
        double notaMedia) {


    public static GetAlumnoDto of (Alumno a) {
        return new GetAlumnoDto(a.getId(), a.getNombre() + " " + a.getApellidos(), 0,0 );
    }


}
