package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customerId;

    private String name;
    private String email;
    private String currentTier;
    private Boolean active;

    public CustomerProfile() {}

    // full constructor
    public CustomerProfile(Long id, String customerId, String name, String email, String currentTier, Boolean active) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.currentTier = currentTier;
        this.active = active;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
