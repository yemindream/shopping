package com.online.shopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Payment {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String cardType;

    private String cardHolder;

    private String billingAddress;

    private LocalDate expirationDate;

    private Byte validCardCheck;

    private Long totalPayment;

    private Date paymentDate;

    private Long purchaseId;

    private Integer state;

    public Payment() {
    }

    public Payment(String cardType, String cardHolder, String billingAddress, LocalDate expirationDate, Long totalPayment, Long purchaseId) {
        this.cardType = cardType;
        this.cardHolder = cardHolder;
        this.billingAddress = billingAddress;
        this.expirationDate = expirationDate;
        this.totalPayment = totalPayment;
        this.purchaseId = purchaseId;
        paymentDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Byte getValidCardCheck() {
        return validCardCheck;
    }

    public void setValidCardCheck(Byte validCardCheck) {
        this.validCardCheck = validCardCheck;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
