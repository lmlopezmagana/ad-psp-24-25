package com.salesianostriana.dam.gradesapi.repositorios;

import com.salesianostriana.dam.gradesapi.modelo.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepositorio extends JpaRepository<Calificacion, Long> {
}
