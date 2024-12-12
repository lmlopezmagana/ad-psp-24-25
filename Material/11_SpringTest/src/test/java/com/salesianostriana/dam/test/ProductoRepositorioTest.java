package com.salesianostriana.dam.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductoRepositorioTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProductoRepositorio repositorio;

    @Test
    void precioMenorQue() {

        Producto p1 = Producto.builder()
                .nombre("Producto 1")
                .precio(8)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Producto 2")
                .precio(10)
                .build();

        Producto p3 = Producto.builder()
                .nombre("Producto 3")
                .precio(12)
                .build();

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);

        List<Producto> resultado = repositorio.findByPrecioLessThan(10);

        assertEquals(1, resultado.size());
        assertEquals(8, resultado.get(0).getPrecio());
        assertEquals("Producto 1", resultado.get(0).getNombre());

    }

}