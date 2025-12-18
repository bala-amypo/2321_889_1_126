package com.example.demo.model;
import jakarta.persistence.*;
public class VisitRecord{
    @Id
    private Long id;
    private Long customerId;
    private LocalDate visitDate;
    private String channel;
}