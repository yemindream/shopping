package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class DeliveryAddress {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String receiverName;

    private String state;

    private String city;

    private String street;

    private String zip;

    private String phone;

    private String email;

    private String emergencyPhone;

    private Integer customerId;

}
