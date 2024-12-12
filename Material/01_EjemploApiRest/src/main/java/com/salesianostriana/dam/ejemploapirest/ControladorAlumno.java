package com.salesianostriana.dam.ejemploapirest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// @RestController = @Controller + @ResponseBody en cada método
@RequiredArgsConstructor
public class ControladorAlumno {

    private final AlumnoRepositorio alumnoRepositorio;


    @GetMapping("/alumno/")
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> result = alumnoRepositorio.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);

    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        return ResponseEntity.of(alumnoRepositorio.findById(id));

    }

    @PostMapping("/alumno/")
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        Alumno nuevo = alumnoRepositorio.save(alumno);
        //return ResponseEntity.created(null).body(nuevo);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> edit(@PathVariable Long id,
                       @RequestBody Alumno alumno) {

        return ResponseEntity.of(alumnoRepositorio.findById(id)
                .map(antiguo -> {
                    antiguo.setNombre(alumno.getNombre());
                    antiguo.setApellidos(alumno.getApellidos());
                    antiguo.setEdad(alumno.getEdad());
                    antiguo.setEmail(alumno.getEmail());
                    return alumnoRepositorio.save(antiguo);
                }));



    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (alumnoRepositorio.existsById(id))
            alumnoRepositorio.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}
