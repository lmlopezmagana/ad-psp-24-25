package com.salesianos.data.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EditProductoCmd(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @DecimalMin("0.01")
        @DecimalMax("99.99")
        double precio,
        Long categoriaId
) {
}
