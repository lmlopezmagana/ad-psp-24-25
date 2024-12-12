package com.salesianostriana.dam.datamodel;

import com.salesianostriana.dam.datamodel.modelo.Alumno;
import com.salesianostriana.dam.datamodel.modelo.Curso;
import com.salesianostriana.dam.datamodel.repo.AlumnoRepository;
import com.salesianostriana.dam.datamodel.repo.CursoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData
{
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    @PostConstruct
    public void init() {

        Curso c1 = Curso.builder()
                .nombre("2º DAM")
                .tutor("Luismi")
                .build();

        cursoRepository.save(c1);


        Alumno a1 = Alumno.builder()
                .nombre("Manuel")
                .build();

        a1.addToCurso(c1);
        //a1.setCurso(c1);

        alumnoRepository.save(a1);

        System.out.println("Nº de alumnos del curso: " + c1.getAlumnos().size());







    }

}
