package com.salesianostriana.dam.gradesapi.repositorios;

import com.salesianostriana.dam.gradesapi.modelo.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentoRepositorio extends JpaRepository<Instrumento, Long> {
}
