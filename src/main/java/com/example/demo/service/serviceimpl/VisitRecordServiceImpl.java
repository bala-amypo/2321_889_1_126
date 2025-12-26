package com.example.demo.service.serviceimpl;

import com.example.demo.entity.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    @Override
    public VisitRecord createVisitRecord(VisitRecord visit) {
        return visitRecordRepository.save(visit);
    }

    @Override
    public List<VisitRecord> getAllVisitRecords() {
        return visitRecordRepository.findAll();
    }
}
