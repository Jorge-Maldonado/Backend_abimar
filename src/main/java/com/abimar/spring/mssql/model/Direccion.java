package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddireccion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "personal")
    private Long personal;

    public Direccion() {
    }

    public Direccion(String direccion, Long personal) {
        this.direccion = direccion;
        this.personal = personal;
    }

    public Long getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Long iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getPersonal() {
        return personal;
    }

    public void setPersonal(Long personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "iddireccion=" + iddireccion +
                ", direccion='" + direccion + '\'' +
                ", personal=" + personal +
                '}';
    }
}
