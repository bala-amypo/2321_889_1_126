package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository purchaseRecordRepository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRecordRepository) {
        this.purchaseRecordRepository = purchaseRecordRepository;
    }

    @Override
    public PurchaseRecord createPurchase(PurchaseRecord purchaseRecord) {
        if (purchaseRecord.getPurchaseDate() == null) {
            purchaseRecord.setPurchaseDate(LocalDate.now());
        }
        return purchaseRecordRepository.save(purchaseRecord);
    }

    @Override
    public PurchaseRecord updatePurchase(Long id, PurchaseRecord purchaseRecord) {
        PurchaseRecord existing = purchaseRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseRecord not found with id: " + id));

        existing.setCustomerId(purchaseRecord.getCustomerId());
        existing.setAmount(purchaseRecord.getAmount());
        existing.setPurchaseDate(purchaseRecord.getPurchaseDate());
        existing.setStoreLocation(purchaseRecord.getStoreLocation());

        return purchaseRecordRepository.save(existing);
    }

    @Override
    public Optional<PurchaseRecord> getPurchaseById(Long id) {
        return purchaseRecordRepository.findById(id);
    }

    @Override
    public Optional<PurchaseRecord> getPurchaseByCustomerId(String customerId) {
        return purchaseRecordRepository.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRecordRepository.findAll();
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRecordRepository.deleteById(id);
    }
}
