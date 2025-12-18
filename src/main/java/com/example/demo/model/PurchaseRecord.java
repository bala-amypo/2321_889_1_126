package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customerId;

    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    // Empty (No-argument) constructor
    public PurchaseRecord() {
    }

    // Parameterized constructor
    public PurchaseRecord(Long id, String customerId, Double amount,
                          LocalDate purchaseDate, String storeLocation) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.storeLocation = storeLocation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
}
