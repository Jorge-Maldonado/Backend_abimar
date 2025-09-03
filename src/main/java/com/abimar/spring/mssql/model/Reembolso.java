package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "reembolso")  // Cambia si realmente la tabla se llama reem_bolso
public class Reembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pedidoid")
    private Long pedidoId;

    @Column(name = "idtransaccion")
    private String idTransaccion;

    @Column(name = "datosreembolso")
    private String datosReembolso;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "status")
    private String status;

    public Reembolso() {}

    public Reembolso(Long pedidoId, String idTransaccion, String datosReembolso, String observacion, String status) {
        this.pedidoId = pedidoId;
        this.idTransaccion = idTransaccion;
        this.datosReembolso = datosReembolso;
        this.observacion = observacion;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getDatosReembolso() {
        return datosReembolso;
    }

    public void setDatosReembolso(String datosReembolso) {
        this.datosReembolso = datosReembolso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reembolso{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", datosReembolso='" + datosReembolso + '\'' +
                ", observacion='" + observacion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
