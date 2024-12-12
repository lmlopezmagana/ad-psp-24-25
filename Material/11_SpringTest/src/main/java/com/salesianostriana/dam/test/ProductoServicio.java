package com.salesianostriana.dam.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio {

    private final ProductoRepositorio repositorio;

    public Producto save(Producto p) {
        return repositorio.save(p);
    }

    public List<Producto> saveAll(List<Producto> p) {
        return repositorio.saveAll(p);
    }

    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    public List<Producto> precioMenorQue10() {
        return repositorio.findByPrecioLessThan(10);
    }

    public List<GetProductoDto> precioMenorQue10YDisponible() {
        List<Producto> todos = repositorio.findAll();

        List<GetProductoDto> resultado = new ArrayList<>();

        for(Producto p : todos) {
            if (p.getPrecio() < 10)
                if (p.isDisponible()) {
                    resultado.add(GetProductoDto.of(p));
                }
        }

        if (resultado.size() == 0)
            return null;
        else return resultado;


    }

}
