package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;
import java.util.Optional;

public interface CustomerProfileService {

    CustomerProfile createCustomerProfile(CustomerProfile customerProfile);

    CustomerProfile updateCustomerProfile(Long id, CustomerProfile customerProfile);

    Optional<CustomerProfile> getCustomerProfileById(Long id);

    Optional<CustomerProfile> getCustomerProfileByCustomerId(String customerId);

    List<CustomerProfile> getAllCustomerProfiles();

    void deleteCustomerProfile(Long id);
}
