package com.example.demo.service.serviceimpl;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    @Autowired
    private TierUpgradeRuleRepository tierUpgradeRuleRepository;

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return tierUpgradeRuleRepository.save(rule);
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleRepository.findAll();
    }

    @Override
    public TierUpgradeRule updateRule(TierUpgradeRule updatedRule) {
        return tierUpgradeRuleRepository.save(updatedRule);
    }
}
