package com.abimar.spring.mssql.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpedido;

    @Column(name = "referenciacobro")
    private String referenciaCobro;

    @Column(name = "idtransaccionpaypal")
    private String idTransaccionPaypal;

    @Column(name = "datospaypal", columnDefinition = "TEXT")
    private String datosPaypal;

    @Column(name = "personal")
    private Long personal;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "costo_envio")
    private Double costoEnvio;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "tipopagoid")
    private Long tipoPagoId;

    @Column(name = "direccion_envio", columnDefinition = "TEXT")
    private String direccionEnvio;

    @Column(name = "status")
    private String status;

    public Pedido() {
    }

    public Pedido(String referenciaCobro, String idTransaccionPaypal, String datosPaypal,
                  Long personal, Date fecha, Double costoEnvio, Double monto,
                  Long tipoPagoId, String direccionEnvio, String status) {
        this.referenciaCobro = referenciaCobro;
        this.idTransaccionPaypal = idTransaccionPaypal;
        this.datosPaypal = datosPaypal;
        this.personal = personal;
        this.fecha = fecha;
        this.costoEnvio = costoEnvio;
        this.monto = monto;
        this.tipoPagoId = tipoPagoId;
        this.direccionEnvio = direccionEnvio;
        this.status = status;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public String getReferenciaCobro() {
        return referenciaCobro;
    }

    public void setReferenciaCobro(String referenciaCobro) {
        this.referenciaCobro = referenciaCobro;
    }

    public String getIdTransaccionPaypal() {
        return idTransaccionPaypal;
    }

    public void setIdTransaccionPaypal(String idTransaccionPaypal) {
        this.idTransaccionPaypal = idTransaccionPaypal;
    }

    public String getDatosPaypal() {
        return datosPaypal;
    }

    public void setDatosPaypal(String datosPaypal) {
        this.datosPaypal = datosPaypal;
    }

    public Long getPersonal() {
        return personal;
    }

    public void setPersonal(Long personal) {
        this.personal = personal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(Double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Long getTipoPagoId() {
        return tipoPagoId;
    }

    public void setTipoPagoId(Long tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idpedido=" + idpedido +
                ", referenciaCobro='" + referenciaCobro + '\'' +
                ", idTransaccionPaypal='" + idTransaccionPaypal + '\'' +
                ", datosPaypal='" + datosPaypal + '\'' +
                ", personal=" + personal +
                ", fecha=" + fecha +
                ", costoEnvio=" + costoEnvio +
                ", monto=" + monto +
                ", tipoPagoId=" + tipoPagoId +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
