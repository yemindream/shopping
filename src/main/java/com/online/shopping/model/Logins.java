package com.online.shopping.model;

import lombok.Data;

import java.util.Date;

@Data
public class Logins {
    private String username;

    private String password;

    private String confirmationCode;

    private Date loginTime;

}
