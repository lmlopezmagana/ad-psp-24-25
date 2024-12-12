package com.salesianostriana.dam.gradesapi.controladores;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.gradesapi.dto.GetAlumnoDto;
import com.salesianostriana.dam.gradesapi.modelo.Alumno;
import com.salesianostriana.dam.gradesapi.repositorios.AlumnoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumno")
public class AlumnoControlador {

    private final AlumnoRepositorio alumnoRepositorio;

    @GetMapping("/")
    public ResponseEntity<Page<GetAlumnoDto>> todos(
            @PageableDefault(page=0, size=5) Pageable pageable
    ) {
        Page<Alumno> pagedResult = alumnoRepositorio.buscarPaginado(pageable);

        if (pagedResult.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(
                pagedResult.map(GetAlumnoDto::of));

    }


}
