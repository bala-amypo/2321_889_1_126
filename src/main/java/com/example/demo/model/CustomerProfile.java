package com.example.demo.model;
import java.util.LocalDate;
public class CustomerProfile{
    @id
    private Long id;
    @column(unique=true)
    private String customerId;
    private String fullName;
    @column(unique=true)
    private String email;
    private String phone;
    private String currentTier;
    private Boolean active;
    private LocalDate createdAt;
}