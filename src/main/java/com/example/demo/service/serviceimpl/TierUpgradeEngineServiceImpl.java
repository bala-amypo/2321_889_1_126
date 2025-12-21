package com.example.demo.service.serviceimpl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {
    @Autowired
    private final TierHistoryRecordRepository tierHistoryRecordRepository;

    public TierUpgradeEngineServiceImpl(
            TierHistoryRecordRepository tierHistoryRecordRepository) {
        this.tierHistoryRecordRepository = tierHistoryRecordRepository;
    }

    @Override
    public Optional<String> evaluateTierUpgrade(
            String currentTier,
            Double totalSpend,
            Integer totalVisits) {

        List<TierHistoryRecord> rules = tierHistoryRecordRepository.findAll();

        return rules.stream()
                .filter(TierHistoryRecord::getActive)
                .filter(rule -> rule.getFromTier().equalsIgnoreCase(currentTier))
                .filter(rule ->
                        totalSpend >= rule.getMinSpend()
                                && totalVisits >= rule.getMinVisits()
                )
                .map(TierHistoryRecord::getToTier)
                .findFirst();
    }
}
