package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "productoid")
    private Long productoId;

    @Column(name = "img")
    private String img;

    public Imagen() {}

    public Imagen(Long id, Long productoId, String img) {
        this.id = id;
        this.productoId = productoId;
        this.img = img;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", img='" + img + '\'' +
                '}';
    }
}
