package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Product {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Integer type;

    private Integer seller;

    private Long price;

    private Integer quantity;

    private String description;

    private byte[] image;

}
