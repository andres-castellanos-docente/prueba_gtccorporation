package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_dane", schema = "institucion", catalog = "")
public class TipoDaneEntity {
    private Integer id;
    private String descripcion;
    private Collection<DaneEntity> danesById;

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
        TipoDaneEntity that = (TipoDaneEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @OneToMany(mappedBy = "tipoDaneByIdTipodane")
    public Collection<DaneEntity> getDanesById() {
        return danesById;
    }

    public void setDanesById(Collection<DaneEntity> danesById) {
        this.danesById = danesById;
    }
}
