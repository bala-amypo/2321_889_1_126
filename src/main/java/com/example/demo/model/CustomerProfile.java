package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_profiles",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "customerId"),
           @UniqueConstraint(columnNames = "email"),
           @UniqueConstraint(columnNames = "phone")
       })
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String fullName;
    private String email;
    private String phone;
    private String currentTier;
    private Boolean active;
    private LocalDateTime createdAt;

    public CustomerProfile() {}

    @PrePersist
    public void prePersist() {
        if (currentTier == null) currentTier = "BRONZE";
        if (active == null) active = true;
        createdAt = LocalDateTime.now();
    }

    // getters and setters
}
