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

    private Integer rating;

    public PurchaseHistory() {
    }

    public PurchaseHistory(Long productId, Integer quantity, Integer deliveryAddress) {
        this.productId = productId;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
        createDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Integer deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
