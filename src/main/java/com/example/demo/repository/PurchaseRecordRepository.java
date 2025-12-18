package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRecordRepository
        extends JpaRepository<PurchaseRecord, Long> {

    Optional<PurchaseRecord> findByCustomerId(String customerId);
}
