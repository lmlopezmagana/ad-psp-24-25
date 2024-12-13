package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
public class MainController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/producto/123")
    public Producto getProducto() {
        return new Producto(123L, "Un producto molón");
    }

    @PostMapping("/producto")
    public Producto nuevoProducto(@RequestBody Producto producto) {
        return producto;
    }


    record Producto(Long id, String nombre){}

}
