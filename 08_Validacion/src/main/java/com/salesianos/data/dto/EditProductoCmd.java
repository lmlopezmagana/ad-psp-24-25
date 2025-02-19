package com.salesianos.data.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EditProductoCmd(
        @NotBlank(message = "{editProductoCmd.nombre.notblank}")
        String nombre,
        @NotBlank
        String descripcion,
        @DecimalMin("0.01")
        @DecimalMax(value = "99.99", message = "Simio no mata simio")
        double precio,
        Long categoriaId
) {
}
