package com.salesianostriana.dam.datamodel.repo;

import com.salesianostriana.dam.datamodel.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}