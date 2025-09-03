package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "tipopago")
public class TipoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idtipopago;

    @Column(name = "tipopago")
    private String tipoPago;

    @Column(name = "status")
    private Integer status;

    public TipoPago() {
    }

    public TipoPago(String tipoPago, Integer status) {
        this.tipoPago = tipoPago;
        this.status = status;
    }

    public Long getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(Long idtipopago) {
        this.idtipopago = idtipopago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoPago{" +
                "idtipopago=" + idtipopago +
                ", tipoPago='" + tipoPago + '\'' +
                ", status=" + status +
                '}';
    }
}
