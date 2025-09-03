package com.abimar.spring.mssql.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "suscripciones")
public class Suscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idsuscripcion;

    @Column(name = "email")  // Cambiar "correo" por "email" si así está en la tabla
    private String email;

    @Column(name = "datecreated")  // Asegúrate que la columna sea "datecreated"
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;

    @Column(name = "status")  // Cambia a "estado" si así está en la tabla
    private Integer status;

    public Suscripciones() {}

    public Suscripciones(Long idsuscripcion, String email, Date datecreated, Integer status) {
        this.idsuscripcion = idsuscripcion;
        this.email = email;
        this.datecreated = datecreated;
        this.status = status;
    }

    public Long getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(Long idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Suscripciones{" +
                "idsuscripcion=" + idsuscripcion +
                ", email='" + email + '\'' +
                ", datecreated=" + datecreated +
                ", status=" + status +
                '}';
    }
}
