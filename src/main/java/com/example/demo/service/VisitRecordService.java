package com.example.demo.service;

import com.example.demo.model.VisitRecord;

import java.util.List;
import java.util.Optional;

public interface VisitRecordService {

    VisitRecord createVisit(VisitRecord visitRecord);

    VisitRecord updateVisit(Long id, VisitRecord visitRecord);

    Optional<VisitRecord> getVisitById(Long id);

    List<VisitRecord> getAllVisits();

    void deleteVisit(Long id);
}
