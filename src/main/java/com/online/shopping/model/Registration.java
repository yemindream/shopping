package com.online.shopping.model;

import lombok.Data;

@Data
public class Registration {
    private Integer userId;

    private String username;

    private String password;

    private String confirmationCode;

    private String confirmationPage;

}
