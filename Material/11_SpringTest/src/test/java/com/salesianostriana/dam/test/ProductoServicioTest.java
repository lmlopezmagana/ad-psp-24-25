package com.salesianostriana.dam.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductoServicioTest {

    @Mock
    ProductoRepositorio repositorio;

    @InjectMocks
    ProductoServicio productoServicio;


    @Test
    void precioMenorQue10YDisponible() {

        List<Producto> data = List.of(
                new Producto(1L, "Producto 1", 3, false),
                new Producto(2L, "Producto 2", 9.99, true),
                new Producto(3L, "Producto 3", 10, true),
                new Producto(4L, "Producto 4", 9.99, false),
                new Producto(5L, "Producto 5", 12, true),
                new Producto(6L, "Producto 6", 15, false)


        );

        // Precondiciones
        Mockito.when(repositorio.findAll()).thenReturn(data);

        // Test
        List<GetProductoDto> expectedResult = List.of(GetProductoDto.builder()
                .id(2l)
                .nombre("Producto 2")
                .build());


        List<GetProductoDto> result =
                productoServicio.precioMenorQue10YDisponible();

        //assertEquals(expectedResult, result);
        assertEquals(1, result.size());

    }
}