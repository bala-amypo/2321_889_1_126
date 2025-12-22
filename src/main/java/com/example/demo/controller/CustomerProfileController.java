package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {
    @Autowired
    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile customerProfile) {
        return ResponseEntity.ok(customerProfileService.createCustomerProfile(customerProfile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return customerProfileService.getCustomerProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/by-customer-id/{customerId}")
    public ResponseEntity<CustomerProfile> getByCustomerId(@PathVariable String customerId) {
        return customerProfileService.getCustomerProfileByCustomerId(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        return ResponseEntity.ok(customerProfileService.getAllCustomerProfiles());
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomerProfile> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerProfile customerProfile) {
        return ResponseEntity.ok(customerProfileService.updateCustomerProfile(id, customerProfile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerProfileService.deleteCustomerProfile(id);
        return ResponseEntity.noContent().build();
    }
}
