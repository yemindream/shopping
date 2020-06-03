package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Payment {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String cardType;

    private String cardHolder;

    private String billingAddress;

    private Date expirationDate;

    private Byte validCardCheck;

    private Long totalPayment;

    private Date paymentDate;

    private Integer purchaseId;

    private Integer state;

}
