package com.example.demo.model;
import jakarta.persistence.*;
public class TierUpgradeRule{
    @Id
    private Long id;
    private String fromTier;
    private String toTier;
    @PositiveOrZero
    private Double minSpend;
    @PositiveOrZero
    private Integer minVisits;
    private Boolean active;
}