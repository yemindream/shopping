package com.online.shopping.vo;

import com.online.shopping.model.Product;
import lombok.Data;

@Data
public class ProductView extends Product {
    private Double avgRatingValue;//average rating

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

