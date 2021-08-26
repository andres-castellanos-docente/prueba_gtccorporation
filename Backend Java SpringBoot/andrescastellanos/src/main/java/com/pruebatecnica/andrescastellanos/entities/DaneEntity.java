package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "dane", schema = "institucion", catalog = "")
public class DaneEntity {
    private Integer id;
    private String descripcion;
    private TipoDaneEntity tipoDaneByIdTipodane;
    private Collection<EstudianteEntity> estudiantesById;

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
        DaneEntity that = (DaneEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion);
    }


    @ManyToOne
    @JoinColumn(name = "id_tipodane", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public TipoDaneEntity getTipoDaneByIdTipodane() {
        return tipoDaneByIdTipodane;
    }

    public void setTipoDaneByIdTipodane(TipoDaneEntity tipoDaneByIdTipodane) {
        this.tipoDaneByIdTipodane = tipoDaneByIdTipodane;
    }

    @OneToMany(mappedBy = "daneByIdDane")
    @JsonIgnore
    public Collection<EstudianteEntity> getEstudiantesById() {
        return estudiantesById;
    }

    public void setEstudiantesById(Collection<EstudianteEntity> estudiantesById) {
        this.estudiantesById = estudiantesById;
    }
}
