package com.salesianostriana.dam.gradesapi.servicios;

import com.salesianostriana.dam.gradesapi.modelo.Alumno;
import com.salesianostriana.dam.gradesapi.modelo.Asignatura;
import com.salesianostriana.dam.gradesapi.repositorios.AlumnoRepositorio;
import com.salesianostriana.dam.gradesapi.repositorios.AsignaturaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsignaturaServicio {

    private final AsignaturaRepositorio repositorio;
    private final AlumnoRepositorio alumnoRepositorio;


    public Optional<Asignatura> buscarAsignaturaPorIdConAlumnos(Long id) {

        Optional<Asignatura> asignatura = repositorio.findById(id);

        //List<Alumno> alumnos = alumnoRepositorio.buscarAlumnoPorAsignaturaId(asignatura.get());
        List<Alumno> alumnos = alumnoRepositorio.buscarAlumnoPorAsignaturaId(id);

        return Optional.empty();

    }

}
