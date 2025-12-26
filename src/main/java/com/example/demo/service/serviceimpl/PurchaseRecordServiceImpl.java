package com.example.demo.service.serviceimpl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    private PurchaseRecordRepository purchaseRecordRepository;

    @Override
    public PurchaseRecord createPurchaseRecord(PurchaseRecord purchase) {
        return purchaseRecordRepository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getAllPurchaseRecords() {
        return purchaseRecordRepository.findAll();
    }
}
