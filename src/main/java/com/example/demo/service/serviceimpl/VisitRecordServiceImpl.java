package com.example.demo.service.serviceimpl;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {
    @Autowired
    private final VisitRecordRepository visitRecordRepository;

    public VisitRecordServiceImpl(VisitRecordRepository visitRecordRepository) {
        this.visitRecordRepository = visitRecordRepository;
    }

    @Override
    public VisitRecord createVisit(VisitRecord visitRecord) {
        if (visitRecord.getVisitDate() == null) {
            visitRecord.setVisitDate(LocalDate.now());
        }
        return visitRecordRepository.save(visitRecord);
    }

    @Override
    public VisitRecord updateVisit(Long id, VisitRecord visitRecord) {
        VisitRecord existing = visitRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitRecord not found with id: " + id));

        existing.setCustomerId(visitRecord.getCustomerId());
        existing.setVisitDate(visitRecord.getVisitDate());
        existing.setChannel(visitRecord.getChannel());

        return visitRecordRepository.save(existing);
    }

    @Override
    public Optional<VisitRecord> getVisitById(Long id) {
        return visitRecordRepository.findById(id);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return visitRecordRepository.findAll();
    }

    @Override
    public void deleteVisit(Long id) {
        visitRecordRepository.deleteById(id);
    }
}
