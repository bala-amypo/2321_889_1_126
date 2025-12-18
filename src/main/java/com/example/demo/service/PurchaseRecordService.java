package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;

import java.util.List;
import java.util.Optional;

public interface PurchaseRecordService {

    PurchaseRecord createPurchase(PurchaseRecord purchaseRecord);

    PurchaseRecord updatePurchase(Long id, PurchaseRecord purchaseRecord);

    Optional<PurchaseRecord> getPurchaseById(Long id);

    Optional<PurchaseRecord> getPurchaseByCustomerId(String customerId);

    List<PurchaseRecord> getAllPurchases();

    void deletePurchase(Long id);
}
