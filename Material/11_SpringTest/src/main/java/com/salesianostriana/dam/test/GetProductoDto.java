package com.salesianostriana.dam.test;

import lombok.Builder;

@Builder
public record GetProductoDto(
        Long id, String nombre
) {

    public static GetProductoDto of(Producto p) {
        return GetProductoDto.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .build();
    }

}
