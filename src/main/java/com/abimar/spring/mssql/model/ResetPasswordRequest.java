package com.abimar.spring.mssql.model;

/**
 * Solicitud de recuperación de contraseña (verificación local).
 */
public class ResetPasswordRequest {

    private String emailUser;
    private String documento;
    private String telefono;
    private String newPassword;

    public ResetPasswordRequest() {
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
