package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Rating {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer customerId;

    private Long productId;

    private Integer value;

    private Date ratingDate;

}
