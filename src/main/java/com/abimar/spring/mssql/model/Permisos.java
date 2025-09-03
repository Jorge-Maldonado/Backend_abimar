package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "permisos")
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpermiso;

    @Column(name = "idrol")
    private Long idrol;

    @Column(name = "idmodulo")
    private Long idmodulo;

    @Column(name = "estado")
    private Integer estado;

    public Permisos() {
    }

    public Permisos(Long idrol, Long idmodulo, Integer estado) {
        this.idrol = idrol;
        this.idmodulo = idmodulo;
        this.estado = estado;
    }

    public Long getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Long idpermiso) {
        this.idpermiso = idpermiso;
    }

    public Long getIdrol() {
        return idrol;
    }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public Long getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Long idmodulo) {
        this.idmodulo = idmodulo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Permisos{" +
                "idpermiso=" + idpermiso +
                ", idrol=" + idrol +
                ", idmodulo=" + idmodulo +
                ", estado=" + estado +
                '}';
    }
}
