package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository tierUpgradeRuleRepository) {
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
    }

    @Override
    public TierUpgradeRule createTierUpgradeRule(TierUpgradeRule tierUpgradeRule) {
        if (tierUpgradeRule.getVisitDate() == null) {
            tierUpgradeRule.setVisitDate(LocalDate.now());
        }
        return tierUpgradeRuleRepository.save(tierUpgradeRule);
    }

    @Override
    public TierUpgradeRule updateTierUpgradeRule(Long id, TierUpgradeRule tierUpgradeRule) {
        TierUpgradeRule existing = tierUpgradeRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "TierUpgradeRule not found with id: " + id));

        existing.setCustomerId(tierUpgradeRule.getCustomerId());
        existing.setVisitDate(tierUpgradeRule.getVisitDate());
        existing.setChannel(tierUpgradeRule.getChannel());

        return tierUpgradeRuleRepository.save(existing);
    }

    @Override
    public Optional<TierUpgradeRule> getTierUpgradeRuleById(Long id) {
        return tierUpgradeRuleRepository.findById(id);
    }

    @Override
    public List<TierUpgradeRule> getAllTierUpgradeRules() {
        return tierUpgradeRuleRepository.findAll();
    }

    @Override
    public void deleteTierUpgradeRule(Long id) {
        tierUpgradeRuleRepository.deleteById(id);
    }
}
