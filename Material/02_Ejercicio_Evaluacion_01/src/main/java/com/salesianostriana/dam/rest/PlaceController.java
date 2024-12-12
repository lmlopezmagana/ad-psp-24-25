package com.salesianostriana.dam.rest;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceRepository placeRepository;

    @GetMapping("/")
    public ResponseEntity<List<Place>> todos() {

        List<Place> result = placeRepository.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> porId(@PathVariable Long id) {
        return ResponseEntity.of(placeRepository.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Place> crearNuevo(
            @RequestBody Place place) {

        return ResponseEntity
                //.status(201)
                .status(HttpStatus.CREATED)
                .body(placeRepository.save(place));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> editarTodoMenosTags(
            @PathVariable Long id,
            @RequestBody Place place
    ) {

        return ResponseEntity.of(
          placeRepository.findById(id)
                  .map(antiguo -> {
                    antiguo.setNombre(place.getNombre());
                    antiguo.setDireccion(place.getDireccion());
                    antiguo.setUrl(place.getUrl());
                    antiguo.setLocalizacion(place.getLocalizacion());
                    antiguo.setDescripcion(place.getDescripcion());
                    return placeRepository.save(antiguo);
                  })
        );


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(
            @PathVariable Long id
    ) {
        if (placeRepository.existsById(id))
            placeRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Place> addTag(
            @PathVariable Long id,
            @PathVariable String nuevo
    ) {
        return ResponseEntity.of(
          placeRepository.findById(id)
                  .map(place -> {
                      if (!place.getTags().contains(nuevo)) {
                          place.setTags(
                                  place.getTags() + ", " + nuevo);
                          return placeRepository.save(place);
                      }

                      return place;
                  })
        );


    }

    @PutMapping("/{id}/tag/del/{eliminar}")
    public ResponseEntity<Place> delTag(
            @PathVariable Long id,
            @PathVariable String eliminar
    ) {
        return ResponseEntity.of(
                placeRepository.findById(id)
                        .map(place -> {
                            if (place.getTags().contains(eliminar)) {
                                String tags = place.getTags();
                                tags = tags.replace(eliminar,"");
                                tags = tags.replace(",,", ",");
                                if (tags.endsWith(","))
                                    tags = tags.substring(0, tags.length()-1);

                                place.setTags(tags);
                                return placeRepository.save(place);
                            }

                            return place;
                        })
        );


    }

    public ResponseEntity<Place> delTagV2(
            @PathVariable Long id,
            @PathVariable String eliminar
    ) {
        return ResponseEntity.of(
                placeRepository.findById(id)
                        .map(place -> {

                            String tags = place.getTags();

                            tags = Arrays.stream(tags.split(","))
                                    .map(String::trim)
                                    .filter(t -> !t.equalsIgnoreCase(eliminar))
                                    .collect(Collectors.joining(","));

                            place.setTags(tags);

                            return placeRepository.save(place);


                        })
        );


    }


}
