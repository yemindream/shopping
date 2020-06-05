package com.online.shopping.vo;

import com.online.shopping.model.Product;
import lombok.Data;

/**
 * Created by min.ye on 2020/6/5.
 */
@Data
public class ProductView extends Product {
    private Double avgRatingValue;//平均评分
}

