package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history_records")
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    @PrePersist
    public void prePersist() {
        changedAt = LocalDateTime.now();
    }

    public TierHistoryRecord() {}

    // getters and setters
}
