package com.salesianos.data.util;

import com.salesianos.data.model.Producto;
import com.salesianos.data.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository repo;


    @PostConstruct
    public void run() {

        Producto p = Producto.builder()
                .nombreProducto("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precioVenta(123.45)
                .build();

        repo.save(p);

        Producto p2 = Producto.builder()
                .nombreProducto("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precioVenta(234.56)
                .build();

        repo.saveAll(List.of(p, p2));


    }

}

