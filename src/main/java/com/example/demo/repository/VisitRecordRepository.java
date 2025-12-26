package com.example.demo.repository;

import com.example.demo.entity.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
}
