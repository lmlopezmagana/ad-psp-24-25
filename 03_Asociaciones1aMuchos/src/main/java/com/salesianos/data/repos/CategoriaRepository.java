package com.salesianos.data.repos;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {
}
