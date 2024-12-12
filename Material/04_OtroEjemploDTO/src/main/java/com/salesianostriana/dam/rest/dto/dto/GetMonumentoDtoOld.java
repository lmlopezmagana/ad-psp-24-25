package com.salesianostriana.dam.rest.dto.dto;

/*
@Value
@Builder
public class GetMonumentoDto {

    private Long id;

    private String nombre, localizacion, urlFoto, nombreCategoria;

    public static GetMonumentoDto of(Monumento monumento) {
        return GetMonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombre())
                .localizacion(monumento.getLoc())
                .urlFoto(monumento.getUrlImagen())
                //.nombreCategoria(monumento.getCategoria().getNombre())
                .nombreCategoria(
                        monumento.getCategoria() != null
                                ? monumento.getCategoria().getNombre()
                                : "Sin categoría"
                )
                .build();
    }

}
*/