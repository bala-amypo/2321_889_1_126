package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {
    @Autowired
    private final PurchaseRecordService purchaseRecordService;

    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<PurchaseRecord> createPurchase(@RequestBody PurchaseRecord purchaseRecord) {
        return ResponseEntity.ok(purchaseRecordService.createPurchase(purchaseRecord));
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRecord> getPurchaseById(@PathVariable Long id) {
        return purchaseRecordService.getPurchaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET BY CUSTOMER ID
    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<PurchaseRecord> getByCustomerId(@PathVariable String customerId) {
        return purchaseRecordService.getPurchaseByCustomerId(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<PurchaseRecord>> getAllPurchases() {
        return ResponseEntity.ok(purchaseRecordService.getAllPurchases());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseRecord> updatePurchase(
            @PathVariable Long id,
            @RequestBody PurchaseRecord purchaseRecord) {
        return ResponseEntity.ok(purchaseRecordService.updatePurchase(id, purchaseRecord));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseRecordService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
}
