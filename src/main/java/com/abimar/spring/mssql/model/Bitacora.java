package com.abimar.spring.mssql.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idbitacora;

    @Column(name = "accion")
    private String accion;

    @Column(name = "datecreate")
    private Date datecreate;

    @Column(name = "idusuario")
    private Long idusuario;

    public Bitacora() {}

    public Bitacora(Long idbitacora, String accion, Date datecreate, Long idusuario) {
        this.idbitacora = idbitacora;
        this.accion = accion;
        this.datecreate = datecreate;
        this.idusuario = idusuario;
    }

    public Long getIdbitacora() {
        return idbitacora;
    }

    public void setIdbitacora(Long idbitacora) {
        this.idbitacora = idbitacora;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "Bitacora{" +
                "idbitacora=" + idbitacora +
                ", accion='" + accion + '\'' +
                ", datecreate=" + datecreate +
                ", idusuario=" + idusuario +
                '}';
    }
}
