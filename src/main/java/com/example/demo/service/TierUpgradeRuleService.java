package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;

import java.util.List;
import java.util.Optional;

public interface TierUpgradeRuleService {

    TierUpgradeRule createTierUpgradeRule(TierUpgradeRule tierUpgradeRule);

    TierUpgradeRule updateTierUpgradeRule(Long id, TierUpgradeRule tierUpgradeRule);

    Optional<TierUpgradeRule> getTierUpgradeRuleById(Long id);

    List<TierUpgradeRule> getAllTierUpgradeRules();

    void deleteTierUpgradeRule(Long id);
}
