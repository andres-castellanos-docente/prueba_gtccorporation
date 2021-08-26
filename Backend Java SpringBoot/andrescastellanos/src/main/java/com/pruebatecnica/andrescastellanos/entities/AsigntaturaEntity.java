package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "asigntatura", schema = "institucion", catalog = "")
public class AsigntaturaEntity {
    private Integer id;
    private String descripcion;
   // private DocenteEntity docenteByIdDocente;


    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsigntaturaEntity that = (AsigntaturaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion) ;
    }



   /* @ManyToOne
    @JoinColumn(name = "id_docente", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    public DocenteEntity getDocenteByIdDocente() {
        return docenteByIdDocente;
    }

    public void setDocenteByIdDocente(DocenteEntity docenteByIdDocente) {
        this.docenteByIdDocente = docenteByIdDocente;
    }*/


}
