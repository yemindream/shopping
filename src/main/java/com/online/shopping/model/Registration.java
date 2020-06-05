package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Registration {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    private String username;

    private String password;

    private String confirmationCode;

    private String confirmationPage;

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public String getConfirmationPage() {
        return confirmationPage;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public void setConfirmationPage(String confirmationPage) {
        this.confirmationPage = confirmationPage;
    }
}
