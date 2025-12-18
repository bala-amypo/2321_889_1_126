package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VisitRecord;
public interface VisitRecordRepository extends JpaRepository<VisitRecord,Long>{

}