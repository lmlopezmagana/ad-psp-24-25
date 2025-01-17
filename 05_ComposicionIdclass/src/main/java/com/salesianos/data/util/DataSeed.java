package com.salesianos.data.util;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.LineaPedido;
import com.salesianos.data.model.Pedido;
import com.salesianos.data.model.Producto;
import com.salesianos.data.repos.CategoriaRepository;
import com.salesianos.data.repos.PedidoRepository;
import com.salesianos.data.repos.ProductoRepository;
import com.salesianos.data.repos.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final TagRepository tagRepository;
    private final PedidoRepository pedidoRepository;

    @PostConstruct
    public void run() {

        //Categoria c = categoriaRepository.getReferenceById(1L);
        /*Categoria c = null;
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(1L);

        if (optionalCategoria.isPresent()) {
            c = optionalCategoria.get();
        }

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p);

        productoRepository.save(p);

        System.out.println("Productos de la categoria C1");
        System.out.println(c.getProductos());

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepository.saveAll(List.of(p, p2));


        productoRepository.findAll()
                .forEach(System.out::println);

    */

        List<Producto> productos = productoRepository.findAll();

        Pedido pedido = Pedido.builder()
                .cliente("Luismi")
                .build();

        pedido.addLineaPedido(LineaPedido.builder()
                .producto(productos.get(0))
                .cantidad(2)
                .precioVenta(productos.get(0).getPrecio())
                .build());


        pedido.addLineaPedido(LineaPedido.builder()
                .producto(productos.get(1))
                .cantidad(1)
                .precioVenta(productos.get(1).getPrecio())
                .build());


        pedidoRepository.save(pedido);

        pedidoRepository.findAll()
                .forEach(p -> {
                    System.out.println(p.toString());
                    System.out.println(p.getLineasPedido());
                    System.out.println("\n");
                });

        pedidoRepository.deleteById(1L);

    }

}

