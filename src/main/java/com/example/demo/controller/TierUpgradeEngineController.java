package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@RestController
@RequestMapping("/api/tier-upgrade-engine")
public class TierUpgradeEngineController {
    
    private final TierUpgradeEngineService tierUpgradeEngineService;

    public TierUpgradeEngineController(
            TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    /**
     * Example:
     * currentTier = SILVER
     * totalSpend = 6000
     * totalVisits = 12
     */
    @GetMapping("/evaluate")
    public ResponseEntity<?> evaluateUpgrade(
            @RequestParam String currentTier,
            @RequestParam Double totalSpend,
            @RequestParam Integer totalVisits) {

        return tierUpgradeEngineService
                .evaluateTierUpgrade(currentTier, totalSpend, totalVisits)
                .map(newTier -> ResponseEntity.ok(
                        Map.of(
                                "eligible", true,
                                "newTier", newTier
                        )
                ))
                .orElse(ResponseEntity.ok(
                        Map.of(
                                "eligible", false,
                                "message", "No tier upgrade applicable"
                        )
                ));
    }
}
