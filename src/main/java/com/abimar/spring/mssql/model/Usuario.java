package com.abimar.spring.mssql.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idusuario;

    @Column(name = "email_user")
    private String emailUser;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "personal")
    private Long personal;

    public Usuario() {
    }

    public Usuario(Long idusuario, String emailUser, String password, String token, Long personal) {
        this.idusuario = idusuario;
        this.emailUser = emailUser;
        this.password = password;
        this.token = token;
        this.personal = personal;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getPersonal() {
        return personal;
    }

    public void setPersonal(Long personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", emailUser='" + emailUser + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", personal=" + personal +
                '}';
    }
}
