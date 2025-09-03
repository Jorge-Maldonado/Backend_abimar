package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "detalle_temp")
public class DetalleTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "personal")
    private Long personal;

    @Column(name = "productoid")
    private Long productoId;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "transaccionid")
    private String transaccionId;

    public DetalleTemp() {
    }

    public DetalleTemp(Long personal, Long productoId, Double precio, Integer cantidad, String transaccionId) {
        this.personal = personal;
        this.productoId = productoId;
        this.precio = precio;
        this.cantidad = cantidad;
        this.transaccionId = transaccionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonal() {
        return personal;
    }

    public void setPersonal(Long personal) {
        this.personal = personal;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    @Override
    public String toString() {
        return "DetalleTemp{" +
                "id=" + id +
                ", personal=" + personal +
                ", productoId=" + productoId +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", transaccionId='" + transaccionId + '\'' +
                '}';
    }
}
