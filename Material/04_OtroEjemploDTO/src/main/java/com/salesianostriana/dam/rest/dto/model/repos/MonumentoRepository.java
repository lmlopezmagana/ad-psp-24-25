package com.salesianostriana.dam.rest.dto.model.repos;

import com.salesianostriana.dam.rest.dto.model.entities.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
