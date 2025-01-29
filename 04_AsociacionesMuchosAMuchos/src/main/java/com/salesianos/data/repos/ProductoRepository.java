package com.salesianos.data.repos;

import com.salesianos.data.dto.GetProductoDto;
import com.salesianos.data.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {


    @Query("""
            select p
            from Producto p left join fetch p.tags
            where p.precio < ?1
            """)
    List<Producto> productosConTags(double p);


    @Query("""
            select new com.salesianos.data.dto.GetProductoDto(
                p.id, p.nombre, p.precio
            )
            from Producto p join p.tags t
            where t.nombre = :tagNombre
            
            """)
    List<GetProductoDto> infoBasicaProductosPorTag(String tagNombre);

    @Query("""
            select p
            from Producto p join p.tags t
            where t.nombre = :tagNombre
            
            """)
    List<Producto> productosPorTag(String tagNombre);


}
