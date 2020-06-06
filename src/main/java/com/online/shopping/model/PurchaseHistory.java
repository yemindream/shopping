package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class PurchaseHistory {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long productId;

    private Integer quantity;

    private Integer deliveryAddress;

    private Date createDate;

    private Integer state;

}
