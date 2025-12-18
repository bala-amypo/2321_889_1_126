package com.example.demo.model;
import java.util.LocalDate;
public class CustomerProfile{
    @id
    private Long id;
    @column(name=unique)
    private String customerId;
    private String fullName;
    @column(name=unique)
    private String email;
    private String phone;
    private String currentTier;
    private Boolean active;
    private LocalDate createdAt;
}