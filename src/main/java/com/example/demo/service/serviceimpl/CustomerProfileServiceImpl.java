package com.example.demo.service.serviceimpl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
    @Autowired
    private final CustomerProfileRepository customerProfileRepository;

    public CustomerProfileServiceImpl(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public CustomerProfile createCustomerProfile(CustomerProfile customerProfile) {
        customerProfile.setCreatedAt(LocalDateTime.now());
        return customerProfileRepository.save(customerProfile);
    }

    @Override
    public CustomerProfile updateCustomerProfile(Long id, CustomerProfile customerProfile) {
        CustomerProfile existing = customerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerProfile not found with id: " + id));

        existing.setFullName(customerProfile.getFullName());
        existing.setEmail(customerProfile.getEmail());
        existing.setPhone(customerProfile.getPhone());
        existing.setCurrentTier(customerProfile.getCurrentTier());
        existing.setActive(customerProfile.getActive());

        return customerProfileRepository.save(existing);
    }

    @Override
    public Optional<CustomerProfile> getCustomerProfileById(Long id) {
        return customerProfileRepository.findById(id);
    }

    @Override
    public Optional<CustomerProfile> getCustomerProfileByCustomerId(String customerId) {
        return customerProfileRepository.findByCustomerId(customerId);
    }

    @Override
    public List<CustomerProfile> getAllCustomerProfiles() {
        return customerProfileRepository.findAll();
    }

    @Override
    public void deleteCustomerProfile(Long id) {
        customerProfileRepository.deleteById(id);
    }
}
