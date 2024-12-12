package com.salesianostriana.dam.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio
        extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioLessThan(double precio);


}
