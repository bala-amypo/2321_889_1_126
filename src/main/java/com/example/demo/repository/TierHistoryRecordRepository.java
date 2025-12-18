package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TierHistoryRecord;
public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord,Long>{

}