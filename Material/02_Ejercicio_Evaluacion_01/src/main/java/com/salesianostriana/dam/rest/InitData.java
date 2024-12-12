package com.salesianostriana.dam.rest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PlaceRepository placeRepository;

    @PostConstruct
    public void init() {

        // Insertar datos de ejemplo

    }

}
