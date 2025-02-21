package com.salesianos.data.dto;

import com.salesianos.data.validation.UniqueNombre;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EditProductoCmd(
        @NotBlank(message = "{editProductoCmd.nombre.notblank}")
        @UniqueNombre(message = "Yo nací en una bañera que no tenía tapón")
        String nombre,
        @NotBlank
        String descripcion,
        @DecimalMin("0.01")
        @DecimalMax(value = "99.99", message = "Simio no mata simio")
        double precio,
        Long categoriaId
) {
}
