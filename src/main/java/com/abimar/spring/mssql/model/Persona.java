package com.abimar.spring.mssql.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idpersona;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private Long telefono;

    @Column(name = "documento")
    private String documento;

    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "rolId")
    private String rolId;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "estado")
    private int estado;

    @Column(name = "tipoDocumentoId")
    private Long tipoDocumentoId;

    public long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(long idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Long getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Long tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public Persona(long idpersona, String identificacion, String nombres, String apellidos, Long telefono, String documento, String razonSocial, String rolId, Date fechaCreacion, int estado, Long tipoDocumentoId) {
        this.idpersona = idpersona;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.documento = documento;
        this.razonSocial = razonSocial;
        this.rolId = rolId;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public Persona() {

    }

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", documento=" + documento + ", razonSocial=" + razonSocial + ", rolId=" + rolId + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + ", tipoDocumentoId=" + tipoDocumentoId + '}';
    }

}
