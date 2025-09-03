package com.abimar.spring.mssql.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcategoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "datecreated")
    private Date dateCreated;

    @Column(name = "status")
    private Integer status;

    public Categoria() {}

    public Categoria(Long idcategoria, String nombre, String descripcion, String ruta, Date dateCreated, Integer status) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruta = ruta;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public Long getIdcategoria() { return idcategoria; }
    public void setIdcategoria(Long idcategoria) { this.idcategoria = idcategoria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }

    public Date getDateCreated() { return dateCreated; }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    @Override
    public String toString() {
        return "Categoria{" +
                "idcategoria=" + idcategoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ruta='" + ruta + '\'' +
                ", dateCreated=" + dateCreated +
                ", status=" + status +
                '}';
    }
}
