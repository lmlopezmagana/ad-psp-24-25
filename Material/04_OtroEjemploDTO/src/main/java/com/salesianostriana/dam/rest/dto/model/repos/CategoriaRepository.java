package com.salesianostriana.dam.rest.dto.model.repos;

import com.salesianostriana.dam.rest.dto.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
