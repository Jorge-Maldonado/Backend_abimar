
package com.abimar.spring.mssql.model;

/**
 *
 * @author Jorge
 */
public class LoginRequest {

    private String emailUser;
    private String password;

    // 👇 Constructores
    public LoginRequest() {}

    public LoginRequest(String emailUser, String password) {
        this.emailUser = emailUser;
        this.password = password;
    }

    // 👇 Getters y Setters
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
}