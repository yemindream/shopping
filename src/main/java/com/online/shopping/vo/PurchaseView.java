package com.online.shopping.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseView {

    private Long id;

    private Long productId;

    private Integer quantity;

    private Integer deliveryAddress;

    private Date createDate;

    private Integer state;

    //product table
    private String type;
    private Double price;
    private String image;

}
