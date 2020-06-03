package com.online.shopping.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by min.ye on 2020/6/3.
 */
@Data
public class PurchaseView {

    private Long id;

    private Long productId;

    private Integer quantity;

    private Integer deleveryAddress;

    private Date createDate;

    private Integer state;

    //product表
    private Integer type;
    private Double price;
    private String image;

}
