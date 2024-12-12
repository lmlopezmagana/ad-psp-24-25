package com.salesianostriana.dam.gradesapi;


import com.salesianostriana.dam.gradesapi.modelo.Alumno;
import com.salesianostriana.dam.gradesapi.modelo.Asignatura;
import com.salesianostriana.dam.gradesapi.repositorios.AlumnoRepositorio;
import com.salesianostriana.dam.gradesapi.repositorios.AsignaturaRepositorio;
import com.salesianostriana.dam.gradesapi.servicios.AsignaturaServicio;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final AlumnoRepositorio alumnoRepositorio;
    private final AsignaturaRepositorio asignaturaRepositorio;
    private final AsignaturaServicio asignaturaServicio;

    @PostConstruct
    public void run() {

        //Optional<Alumno> a = alumnoRepositorio.findById(1L);
        //Optional<Alumno> a = alumnoRepositorio.buscarAlumnoPorIdConAsignaturas(1L);
        //a.get();
        //asignaturaServicio.buscarAsignaturaPorIdConAlumnos(1l);


        alumnoRepositorio.buscarAlumnosConCantidadAsignaturasYNotaMedia()
                .forEach(System.out::println);



       Page<Alumno> result = alumnoRepositorio.buscarPaginado(
                PageRequest.of(0, 20)
        );

        result.getContent().forEach(alumno -> {
            String asignaturas =
                    alumno.getAsignaturas().stream()
                            .map(Asignatura::getNombre)
                            .collect(Collectors.joining(", "));

            System.out.printf("Nombre: %s, Fecha de nacimiento: %s, Email: %s, Asignaturas: %s%n", alumno.getNombre()+" "+alumno.getApellidos(),
                    alumno.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    alumno.getEmail(), StringUtils.isNotBlank(asignaturas) ? asignaturas : "Sin matrícula");
        });





    }
}



