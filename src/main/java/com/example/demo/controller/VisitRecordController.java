package com.example.demo.controller;

import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    @PostMapping
    public VisitRecord createVisit(@RequestBody VisitRecord visit) {
        return visitRecordService.createVisitRecord(visit);
    }

    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitRecordService.getAllVisitRecords();
    }
}
