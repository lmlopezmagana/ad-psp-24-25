package com.salesianostriana.dam.gradesapi.repositorios;

import com.salesianostriana.dam.gradesapi.modelo.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepositorio extends JpaRepository<Asignatura, Long> {
}
