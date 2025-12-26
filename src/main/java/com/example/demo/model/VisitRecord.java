package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String channel;
    private Integer visits;

    public VisitRecord() {}

    public VisitRecord(Long id, String customerId, String channel, Integer visits) {
        this.id = id;
        this.customerId = customerId;
        this.channel = channel;
        this.visits = visits;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public Integer getVisits() { return visits; }
    public void setVisits(Integer visits) { this.visits = visits; }
}
