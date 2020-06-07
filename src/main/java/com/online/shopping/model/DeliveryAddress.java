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

    public DeliveryAddress() {
    }

    public DeliveryAddress(String receiverName, String state, String city, String street, String zip, String phone, String email, String emergencyPhone, Integer customerId) {
        this.receiverName = receiverName;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.emergencyPhone = emergencyPhone;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }
}
