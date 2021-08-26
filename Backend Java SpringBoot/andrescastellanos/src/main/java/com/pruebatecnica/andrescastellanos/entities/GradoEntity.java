package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "grado", schema = "institucion", catalog = "")
public class GradoEntity {
    private Integer id;
    private String descripcion;
   /* private Collection<DocenteEntity> docentesById;
    private Collection<EstudianteEntity> estudiantesById;*/

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
        GradoEntity that = (GradoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

  /*  @OneToMany(mappedBy = "gradoByIdGradoresponsable")
    public Collection<DocenteEntity> getDocentesById() {
        return docentesById;
    }

    public void setDocentesById(Collection<DocenteEntity> docentesById) {
        this.docentesById = docentesById;
    }

    @OneToMany(mappedBy = "gradoByIdGrado")
    @JsonIgnore
    public Collection<EstudianteEntity> getEstudiantesById() {
        return estudiantesById;
    }

    public void setEstudiantesById(Collection<EstudianteEntity> estudiantesById) {
        this.estudiantesById = estudiantesById;
    }*/
}
