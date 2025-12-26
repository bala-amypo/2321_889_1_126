package com.example.demo.service.serviceimpl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Autowired
    private TierHistoryRecordRepository historyRepository;

    @Override
    public void upgradeCustomerTier(CustomerProfile customer, List<PurchaseRecord> purchases, List<TierUpgradeRule> rules) {
        double totalSpend = purchases.stream().mapToDouble(PurchaseRecord::getAmount).sum();
        int totalVisits = purchases.stream().mapToInt(PurchaseRecord::getVisits).sum();

        for (TierUpgradeRule rule : rules) {
            if (rule.getFromTier().equals(customer.getCurrentTier()) &&
                totalSpend >= rule.getMinSpend() &&
                totalVisits >= rule.getMinVisits()) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getToTier());

                TierHistoryRecord history = new TierHistoryRecord();
                history.setCustomerId(customer.getCustomerId());
                history.setOldTier(oldTier);
                history.setNewTier(rule.getToTier());
                history.setReason("Upgrade due to spend/visits");
                historyRepository.save(history);
            }
        }
    }
}
