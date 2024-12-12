package com.salesianostriana.dam.ejemploapirest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
@Repository
public class RepositorioAlumno {

    private List<Alumno> alumnos;

    public RepositorioAlumno() {
        alumnos = new ArrayList<>();

        alumnos.add(
          Alumno.builder()
                  .id(1)
                  .nombre("Pepe")
                  .apellidos("Pérez Pérez")
                  .edad(19)
                  .email("pepe.perez@triana.salesianos.edu")
                  .build()
        );

        alumnos.add(
                Alumno.builder()
                        .id(2)
                        .nombre("Ana")
                        .apellidos("López Muñoz")
                        .edad(21)
                        .email("ana.lopez@triana.salesianos.edu")
                        .build()
        );

        alumnos.add(
                Alumno.builder()
                        .id(3)
                        .nombre("Manuel")
                        .apellidos("No Te Arrimes a la Pared")
                        .edad(23)
                        .email("manuel.note@triana.salesianos.edu")
                        .build()
        );


    }


    public List<Alumno> findAll() {
        return Collections.unmodifiableList(alumnos);
    }

    public Optional<Alumno> findById(int id) {

        return alumnos.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

    }

    public Alumno save(Alumno a) {
        alumnos.add(a);
        return a;
    }

    public Alumno edit(Alumno a) {
        int pos;
        if ((pos = indexOf(a.getId())) == -1) {
            return save(a);
        }
        else {
            return alumnos.set(pos, a);
        }
    }

    public void delete(Alumno a) {
        int pos;
        if ((pos = indexOf(a.getId())) != -1) {
            alumnos.remove(pos);
        }
    }

    private int indexOf(int id) {

        int pos = -1;

        for(int i = 0; i < alumnos.size() && pos == -1; i++) {
            if (alumnos.get(i).getId() == id)
                pos = i;
        }

        return pos;
    }



}
*/