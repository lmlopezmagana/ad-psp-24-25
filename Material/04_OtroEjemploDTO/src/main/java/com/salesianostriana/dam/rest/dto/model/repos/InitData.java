package com.salesianostriana.dam.rest.dto.model.repos;

import com.salesianostriana.dam.rest.dto.model.entities.Categoria;
import com.salesianostriana.dam.rest.dto.model.entities.Dificultad;
import com.salesianostriana.dam.rest.dto.model.entities.Monumento;
import com.salesianostriana.dam.rest.dto.model.entities.Ruta;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CategoriaRepository categoriaRepository;
    private final MonumentoRepository monumentoRepository;
    private final RutaRepository rutaRepository;

    @PostConstruct
    public void init() {

        Categoria c = new Categoria(1L, "Religiosos");
        categoriaRepository.save(c);

        Monumento m1 = Monumento.builder()
                .nombre("Catedral de Sevilla")
                .loc("123,123")
                .ciudad("Sevilla")
                .descripcion("asñdjflaksdlfñj ñlkaf dfjkañd fklas ")
                .imagenes(List.of("http://imagen1.jpg", "http://imagen2.jpg"))
                .categoria(c)
                .pais("España")
                .codigoPais("es")
                .build();

        Monumento m2 = Monumento.builder()
                .nombre("San Luis de los Franceses")
                .loc("123,123")
                .ciudad("Sevilla")
                .descripcion("asñdjflaksdlfñj ñlkaf dfjkañd fklas ")
                .imagenes(List.of("http://imagen3.jpg", "http://imagen4.jpg"))
                .categoria(c)
                .pais("España")
                .codigoPais("es")
                .build();

        monumentoRepository.saveAll(List.of(m1, m2));


        Ruta r = Ruta.builder()
                .nombre("Iglesias wenas de verdá")
                .dificultad(Dificultad.BAJA)
                .tiempo(20)
                .monumentos(List.of(m1, m2))
                .build();
        rutaRepository.save(r);

    }

}
