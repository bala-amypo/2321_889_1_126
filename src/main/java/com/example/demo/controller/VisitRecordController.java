package com.example.demo.controller;

import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitRecordController {

    private final VisitRecordService service;

    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return service.recordVisit(visit);
    }

    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return service.getVisitById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getByCustomer(@PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }

    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return service.getAllVisits();
    }
}
