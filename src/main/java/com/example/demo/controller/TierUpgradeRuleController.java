package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-upgrade-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

    public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
        this.tierUpgradeRuleService = tierUpgradeRuleService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TierUpgradeRule> createTierUpgradeRule(
            @RequestBody TierUpgradeRule tierUpgradeRule) {
        return ResponseEntity.ok(
                tierUpgradeRuleService.createTierUpgradeRule(tierUpgradeRule)
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TierUpgradeRule> getTierUpgradeRuleById(@PathVariable Long id) {
        return tierUpgradeRuleService.getTierUpgradeRuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<TierUpgradeRule>> getAllTierUpgradeRules() {
        return ResponseEntity.ok(tierUpgradeRuleService.getAllTierUpgradeRules());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TierUpgradeRule> updateTierUpgradeRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule tierUpgradeRule) {
        return ResponseEntity.ok(
                tierUpgradeRuleService.updateTierUpgradeRule(id, tierUpgradeRule)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTierUpgradeRule(@PathVariable Long id) {
        tierUpgradeRuleService.deleteTierUpgradeRule(id);
        return ResponseEntity.noContent().build();
    }
}
