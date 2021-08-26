package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "docente", schema = "institucion", catalog = "")
public class DocenteEntity {
    private Integer id;
    private String numerodocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private Integer asigDictadas;
    private String gradoEscolaridad;
    private String email;
    private String fijo;
    private String celular;
    private GradoEntity gradoByIdGradoresponsable;
   /* private Collection<AsigntaturaEntity> asigntaturasById;
    private TipoDocumentoEntity tipoDocumentoByIdTipodocumento;
    private GradoEntity gradoByIdGradoresponsable;*/

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numerodocumento", nullable = true, length = 45)
    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    @Basic
    @Column(name = "nombres", nullable = true, length = 45)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "apellidos", nullable = true, length = 45)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "fecha_nacimiento", nullable = true, length = 45)
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "asig_dictadas", nullable = true)
    public Integer getAsigDictadas() {
        return asigDictadas;
    }

    public void setAsigDictadas(Integer asigDictadas) {
        this.asigDictadas = asigDictadas;
    }

    @Basic
    @Column(name = "grado_escolaridad", nullable = true, length = 45)
    public String getGradoEscolaridad() {
        return gradoEscolaridad;
    }

    public void setGradoEscolaridad(String gradoEscolaridad) {
        this.gradoEscolaridad = gradoEscolaridad;
    }


    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fijo", nullable = true, length = 45)
    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    @Basic
    @Column(name = "celular", nullable = true, length = 45)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocenteEntity that = (DocenteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(numerodocumento, that.numerodocumento) && Objects.equals(nombres, that.nombres) && Objects.equals(apellidos, that.apellidos) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(asigDictadas, that.asigDictadas) && Objects.equals(gradoEscolaridad, that.gradoEscolaridad) && Objects.equals(email, that.email) && Objects.equals(fijo, that.fijo) && Objects.equals(celular, that.celular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  numerodocumento, nombres, apellidos, fechaNacimiento, asigDictadas, gradoEscolaridad,  email, fijo, celular);
    }

   /* @OneToMany(mappedBy = "docenteByIdDocente")
    public Collection<AsigntaturaEntity> getAsigntaturasById() {
        return asigntaturasById;
    }

    public void setAsigntaturasById(Collection<AsigntaturaEntity> asigntaturasById) {
        this.asigntaturasById = asigntaturasById;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento", referencedColumnName = "id", nullable = false)
    public TipoDocumentoEntity getTipoDocumentoByIdTipodocumento() {
        return tipoDocumentoByIdTipodocumento;
    }

    public void setTipoDocumentoByIdTipodocumento(TipoDocumentoEntity tipoDocumentoByIdTipodocumento) {
        this.tipoDocumentoByIdTipodocumento = tipoDocumentoByIdTipodocumento;
    }

    @ManyToOne
    @JoinColumn(name = "id_gradoresponsable", referencedColumnName = "id", nullable = false)
    public GradoEntity getGradoByIdGradoresponsable() {
        return gradoByIdGradoresponsable;
    }

    public void setGradoByIdGradoresponsable(GradoEntity gradoByIdGradoresponsable) {
        this.gradoByIdGradoresponsable = gradoByIdGradoresponsable;
    }*/
}
