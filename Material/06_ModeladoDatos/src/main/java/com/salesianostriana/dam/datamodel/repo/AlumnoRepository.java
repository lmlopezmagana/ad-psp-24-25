package com.salesianostriana.dam.datamodel.repo;

import com.salesianostriana.dam.datamodel.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}