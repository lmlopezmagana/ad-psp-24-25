package com.salesianostriana.dam.gradesapi.servicios;

import com.salesianostriana.dam.gradesapi.repositorios.CalificacionRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalificacionServicio {

    private final CalificacionRepositorio repositorio;

}
