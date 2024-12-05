package com.ElectronicManagementSystemPayment.entity;

import com.ElectronicsStoreManagementsystem.entity.Orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "amount")
    private int amount;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Orders orderId;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, String customerName, int amount, Boolean paymentStatus, Orders orderId) {
        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.orderId = orderId;
    }

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", customerName=" + customerName + ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", orderId=" + orderId + "]";
    }
}