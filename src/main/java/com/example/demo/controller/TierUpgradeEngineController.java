package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tier-upgrade")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService tierUpgradeEngineService;

    @PostMapping("/upgrade")
    public void upgradeCustomerTier(@RequestBody CustomerProfile customer,
                                    @RequestBody List<PurchaseRecord> purchases,
                                    @RequestBody List<TierUpgradeRule> rules) {
        tierUpgradeEngineService.upgradeCustomerTier(customer, purchases, rules);
    }
}
