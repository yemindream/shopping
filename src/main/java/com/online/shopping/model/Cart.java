package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Cart {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer customerId;

    private Long productId;

    private Integer quantity;

}
