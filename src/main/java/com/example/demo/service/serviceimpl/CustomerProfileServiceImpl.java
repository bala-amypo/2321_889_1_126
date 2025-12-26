package com.example.demo.service.serviceimpl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @Override
    public CustomerProfile createCustomerProfile(CustomerProfile customer) {
        customer.setActive(true);
        return customerProfileRepository.save(customer);
    }

    @Override
    public List<CustomerProfile> getAllCustomerProfiles() {
        return customerProfileRepository.findAll();
    }

    @Override
    public CustomerProfile updateCustomerTier(String customerId, String newTier) {
        Optional<CustomerProfile> optional = customerProfileRepository.findByCustomerId(customerId);
        if (optional.isPresent()) {
            CustomerProfile customer = optional.get();
            customer.setCurrentTier(newTier);
            return customerProfileRepository.save(customer);
        }
        return null;
    }

    @Override
    public void deactivateCustomer(String customerId) {
        Optional<CustomerProfile> optional = customerProfileRepository.findByCustomerId(customerId);
        if (optional.isPresent()) {
            CustomerProfile customer = optional.get();
            customer.setActive(false);
            customerProfileRepository.save(customer);
        }
    }
}
