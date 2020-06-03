package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Seller {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private String sellingAddress;

    private String email;

    private String companyName;

}
