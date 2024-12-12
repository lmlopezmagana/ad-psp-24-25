package com.salesianostriana.dam.rest.dto.dto;

import java.util.List;

public record EditRutaDto(
        String nombre,
        int duracion,
        String dificultad,
        List<Long> monumentos) {


}
