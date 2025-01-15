package com.salesianos.data.dto;

import com.salesianos.data.model.Producto;

public record GetProductoDto(
        Long id,
        String nombre,
        double precio,
        GetCategoriaDto categoria
) {

    public static GetProductoDto of(Producto p) {
        return new GetProductoDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                GetCategoriaDto.of(p.getCategoria())
        );
    }

}
