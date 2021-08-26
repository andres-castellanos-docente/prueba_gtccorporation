package com.pruebatecnica.andrescastellanos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estudiante", schema = "institucion", catalog = "")
@Embeddable
public class EstudianteEntity {
    private Integer id;
    private String numerodocumento;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String direccion;
    private String email;
    private String fijo;
    private String celular;
    private TipoDocumentoEntity tipoDocumentoByIdTipodocumento;
    private GradoEntity gradoByIdGrado;
    private DaneEntity daneByIdDane;

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
    @Column(name = "nombre", nullable = true, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "direccion", nullable = true, length = 45)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public TipoDocumentoEntity getTipoDocumentoByIdTipodocumento() {
        return tipoDocumentoByIdTipodocumento;
    }

    public void setTipoDocumentoByIdTipodocumento(TipoDocumentoEntity tipoDocumentoByIdTipodocumento) {
        this.tipoDocumentoByIdTipodocumento = tipoDocumentoByIdTipodocumento;
    }

    @ManyToOne
    @JoinColumn(name = "id_grado", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public GradoEntity getGradoByIdGrado() {
        return gradoByIdGrado;
    }

    public void setGradoByIdGrado(GradoEntity gradoByIdGrado) {
        this.gradoByIdGrado = gradoByIdGrado;
    }

    @ManyToOne
    @JoinColumn(name = "id_dane", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public DaneEntity getDaneByIdDane() {
        return daneByIdDane;
    }

    public void setDaneByIdDane(DaneEntity daneByIdDane) {
        this.daneByIdDane = daneByIdDane;
    }

}
