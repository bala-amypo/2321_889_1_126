package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PurchaseRecord;
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord,Long>{

}