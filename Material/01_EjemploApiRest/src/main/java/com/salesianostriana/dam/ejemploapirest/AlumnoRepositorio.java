package com.salesianostriana.dam.ejemploapirest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepositorio
        extends JpaRepository<Alumno, Long> {
}
