package com.payment.razorpay.domain;

public class TransactionDetails {
    private  String orderId;
    private  String currency;

    public TransactionDetails(String orderId, String currency, String key, Integer amount) {
        this.orderId = orderId;
        this.currency = currency;
        this.key = key;
        this.amount = amount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private  String key;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



    private  Integer amount;
}
