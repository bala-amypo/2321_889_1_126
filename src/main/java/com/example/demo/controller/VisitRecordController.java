package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService visitRecordService;

    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<VisitRecord> createVisit(@RequestBody VisitRecord visitRecord) {
        return ResponseEntity.ok(visitRecordService.createVisit(visitRecord));
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<VisitRecord> getVisitById(@PathVariable Long id) {
        return visitRecordService.getVisitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<VisitRecord>> getAllVisits() {
        return ResponseEntity.ok(visitRecordService.getAllVisits());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<VisitRecord> updateVisit(
            @PathVariable Long id,
            @RequestBody VisitRecord visitRecord) {
        return ResponseEntity.ok(
                visitRecordService.updateVisit(id, visitRecord)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitRecordService.deleteVisit(id);
        return ResponseEntity.noContent().build();
    }
}
