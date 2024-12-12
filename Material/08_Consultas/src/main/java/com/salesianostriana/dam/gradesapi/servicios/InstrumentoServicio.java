package com.salesianostriana.dam.gradesapi.servicios;

import com.salesianostriana.dam.gradesapi.repositorios.InstrumentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentoServicio {

    private final InstrumentoRepositorio repositorio;
}
