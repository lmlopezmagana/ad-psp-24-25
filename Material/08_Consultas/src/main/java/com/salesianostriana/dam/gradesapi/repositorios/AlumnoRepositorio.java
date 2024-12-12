package com.salesianostriana.dam.gradesapi.repositorios;

import com.salesianostriana.dam.gradesapi.dto.GetAlumnoDto;
import com.salesianostriana.dam.gradesapi.modelo.Alumno;
import com.salesianostriana.dam.gradesapi.modelo.Asignatura;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {

/*
SQL
select *
from alumno join alumno_asignaturas using (alumno_id)
    join asignatura using (asignatura_id)
where alumno.id = ?
 */


    @Query("""
            select a from Alumno a
                join fetch a.asignaturas
                where a.id = ?1   
            """)
    Optional<Alumno> buscarAlumnoPorIdConAsignaturas(Long id);


    @Query("""
            select a from Alumno a
            join fetch a.asignaturas as asig
            where asig.id = ?1
            """)
    List<Alumno> buscarAlumnoPorAsignaturaId(Long id);

    @Query("""
            select a from Alumno a
            where ?1 MEMBER OF a.asignaturas
            """)
    List<Alumno> buscarAlumnoPorAsignaturaId(Asignatura a);

    @Query("""
            select new com.salesianostriana.dam.gradesapi.dto.GetAlumnoDto(
                a.id, a.nombre || ' ' || a.apellidos, size(a.asignaturas), 
                (select case when avg(c.calificacion) is not null then round(avg(c.calificacion),2) else 0 end 
                from Calificacion c 
                where c.alumno.id = a.id))
            from Alumno a
            
            """)
    List<GetAlumnoDto> buscarAlumnosConCantidadAsignaturasYNotaMedia();


    @Query("""
            select a from Alumno a
            left join fetch a.asignaturas
           """)
    Page<Alumno> buscarPaginado(Pageable pageable);


}
