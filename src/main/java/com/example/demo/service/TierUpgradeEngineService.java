package com.example.demo.service;

import java.util.Optional;

public interface TierUpgradeEngineService {

    Optional<String> evaluateTierUpgrade(
            String currentTier,
            Double totalSpend,
            Integer totalVisits
    );
}
