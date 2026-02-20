package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerDetailsDTO;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private final CustomerDetailsRepository repository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDetailsDTO createCustomer(CustomerDetailsDTO dto) {
        CustomerDetails entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public List<CustomerDetailsDTO> getAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDetailsDTO getCustomerById(String id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerDetailsDTO updateCustomer(String id, CustomerDetailsDTO dto) {
        CustomerDetails existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCustomerFullName(dto.getCustomerFullName());
            existing.setCustomerGender(dto.getCustomerGender());
            existing.setCustomerType(dto.getCustomerType());
            existing.setCustomerDateOfBirth(dto.getCustomerDateOfBirth());
            existing.setCustomerPreferredLanguage(dto.getCustomerPreferredLanguage());
            existing.setCustomerStatus(dto.getCustomerStatus());
            existing.setCustomerCountryOfOrigin(dto.getCustomerCountryOfOrigin());

            return mapToDTO(repository.save(existing));
        }

        return null;
    }

    private CustomerDetailsDTO mapToDTO(CustomerDetails entity) {
        CustomerDetailsDTO dto = new CustomerDetailsDTO();
        dto.setCustomerIdentifier(entity.getCustomerIdentifier());
        dto.setCustomerFullName(entity.getCustomerFullName());
        dto.setCustomerGender(entity.getCustomerGender());
        dto.setCustomerType(entity.getCustomerType());
        dto.setCustomerDateOfBirth(entity.getCustomerDateOfBirth());
        dto.setCustomerPreferredLanguage(entity.getCustomerPreferredLanguage());
        dto.setCustomerStatus(entity.getCustomerStatus());
        dto.setCustomerCountryOfOrigin(entity.getCustomerCountryOfOrigin());
        return dto;
    }

    private CustomerDetails mapToEntity(CustomerDetailsDTO dto) {
        CustomerDetails entity = new CustomerDetails();
        entity.setCustomerIdentifier(dto.getCustomerIdentifier());
        entity.setCustomerFullName(dto.getCustomerFullName());
        entity.setCustomerGender(dto.getCustomerGender());
        entity.setCustomerType(dto.getCustomerType());
        entity.setCustomerDateOfBirth(dto.getCustomerDateOfBirth());
        entity.setCustomerPreferredLanguage(dto.getCustomerPreferredLanguage());
        entity.setCustomerStatus(dto.getCustomerStatus());
        entity.setCustomerCountryOfOrigin(dto.getCustomerCountryOfOrigin());
        return entity;
    }
}
