package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class TierUpgradeRuleController {

    @Autowired
    private TierUpgradeRuleService tierUpgradeRuleService;

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.createRule(rule);
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }

    @PutMapping
    public TierUpgradeRule updateRule(@RequestBody TierUpgradeRule updatedRule) {
        return tierUpgradeRuleService.updateRule(updatedRule);
    }
}
