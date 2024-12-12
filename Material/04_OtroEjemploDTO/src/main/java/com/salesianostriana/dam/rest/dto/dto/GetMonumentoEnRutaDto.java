package com.salesianostriana.dam.rest.dto.dto;

import com.salesianostriana.dam.rest.dto.model.entities.Monumento;

public record GetMonumentoEnRutaDto(
        Long id,
        String nombre,
        String localizacion,
        String localidad,
        String imagen,
        String nombreCategoria
) {

    public static GetMonumentoEnRutaDto of (Monumento m) {
        return new GetMonumentoEnRutaDto(
                m.getId(),
                m.getNombre(),
                m.getLoc(),
                m.getCiudad(),
                m.getImagenes().isEmpty() ?
                        "https://place-hold.it/300" :
                        m.getImagenes().get(0)
                ,
                m.getCategoria() != null
                ? m.getCategoria().getNombre()
                : "Sin categoría"
        );
    }


}
