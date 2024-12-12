package com.salesianostriana.dam.gradesapi.servicios;

import com.salesianostriana.dam.gradesapi.repositorios.AlumnoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoServicio {

    private final AlumnoRepositorio repositorio;

}
