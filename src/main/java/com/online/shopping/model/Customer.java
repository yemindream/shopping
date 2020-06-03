package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Customer {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private String phoneNumber;

    private String email;

    private Byte gender;

    private Date birthdate;

    private String state;

    private String city;

    private String street;

    private String zip;

}
