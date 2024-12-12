package com.salesianostriana.dam.rest.dto.dto;

import com.salesianostriana.dam.rest.dto.model.entities.Categoria;

public record GetCategoriaDto(Long id, String nombreCategoria) {


    public static GetCategoriaDto of (Categoria c) {
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }


}
