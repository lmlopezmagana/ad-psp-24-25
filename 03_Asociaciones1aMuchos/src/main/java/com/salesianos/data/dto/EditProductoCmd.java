package com.salesianos.data.dto;

public record EditProductoCmd(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) {
}
