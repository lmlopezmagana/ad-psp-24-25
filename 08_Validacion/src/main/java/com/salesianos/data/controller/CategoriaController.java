package com.salesianos.data.controller;


import com.salesianos.data.dto.EditProductoCmd;
import com.salesianos.data.dto.GetProductoDto;
import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Producto;
import com.salesianos.data.service.CategoriaService;
import com.salesianos.data.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria nueva) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        categoriaService.save(nueva));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody Categoria aEditar,
                         @PathVariable Long id) {
        return categoriaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
