package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idtipodocumento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado;

    public TipoDocumento() {
    }

    public TipoDocumento(String descripcion, Integer estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(Long idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "idtipodocumento=" + idtipodocumento +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
