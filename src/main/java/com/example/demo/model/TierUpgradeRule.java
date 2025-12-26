package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = {"fromTier","toTier"}))
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active;

    @PrePersist
    public void prePersist() {
        if (active == null) active = true;
    }

    public TierUpgradeRule() {}

    // getters and setters
}
