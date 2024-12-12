package com.salesianostriana.dam.gradesapi.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(ReferenteEvaluacionPK.class)
public class ReferenteEvaluacion {

    @Id
    @ManyToOne
    private Asignatura asignatura;

    @Id
    private String codReferente;

    private String descripcion;

    public ReferenteEvaluacionPK getId() {
        return new ReferenteEvaluacionPK(asignatura, codReferente);
    }

    public void setId(ReferenteEvaluacionPK referenteEvaluacionPK) {
        this.asignatura = referenteEvaluacionPK.getAsignatura();
        this.codReferente = referenteEvaluacionPK.getCodReferente();
    }

}
