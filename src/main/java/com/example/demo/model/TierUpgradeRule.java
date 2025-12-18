package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private LocalDate visitDate;
    private String channel;

    
    public TierUpgradeRule() {
    }

    
    public TierUpgradeRule(Long id, Long customerId, LocalDate visitDate, String channel) {
        this.id = id;
        this.customerId = customerId;
        this.visitDate = visitDate;
        this.channel = channel;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
