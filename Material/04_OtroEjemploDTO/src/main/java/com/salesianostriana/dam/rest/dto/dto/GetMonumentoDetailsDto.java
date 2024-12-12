package com.salesianostriana.dam.rest.dto.dto;

import com.salesianostriana.dam.rest.dto.model.entities.Monumento;

import java.util.List;

public record GetMonumentoDetailsDto (
        Long id,
        String nombre,
        String localizacion,
        String localidad,
        String codigoPais,
        String pais,
        String descripcion,
        List<String> imagenes,
        GetCategoriaDto categoria

) {

    public static GetMonumentoDetailsDto of (Monumento m) {
        return new GetMonumentoDetailsDto(
                m.getId(),
                m.getNombre(),
                m.getLoc(),
                m.getCiudad(),
                m.getCodigoPais(),
                m.getPais(),
                m.getDescripcion(),
                m.getImagenes(),
                (m.getCategoria() == null) ? null
                        : GetCategoriaDto.of(m.getCategoria())

        );
    }


}
