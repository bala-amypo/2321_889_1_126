package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private Double amount;
    private Integer visits;

    public PurchaseRecord() {}

    public PurchaseRecord(Long id, String customerId, Double amount, Integer visits) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.visits = visits;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Integer getVisits() { return visits; }
    public void setVisits(Integer visits) { this.visits = visits; }
}
