package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomerProfile(customer);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomerProfiles();
    }

    @PutMapping("/{customerId}/tier")
    public CustomerProfile updateTier(@PathVariable String customerId, @RequestParam String newTier) {
        return customerProfileService.updateCustomerTier(customerId, newTier);
    }

    @PutMapping("/{customerId}/deactivate")
    public void deactivateCustomer(@PathVariable String customerId) {
        customerProfileService.deactivateCustomer(customerId);
    }
}
