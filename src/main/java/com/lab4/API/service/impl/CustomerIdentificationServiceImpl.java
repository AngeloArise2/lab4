package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerIdentificationDTO;
import com.lab4.API.entity.CustomerIdentification;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerIdentificationRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerIdentificationService;

@Service
public class CustomerIdentificationServiceImpl implements CustomerIdentificationService {

    private final CustomerIdentificationRepository identificationRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerIdentificationServiceImpl(
            CustomerIdentificationRepository identificationRepository,
            CustomerDetailsRepository customerRepository) {

        this.identificationRepository = identificationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerIdentificationDTO createCustomerIdentification(CustomerIdentificationDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerIdentification entity = new CustomerIdentification();
        entity.setIdentificationType(dto.getIdentificationType());
        entity.setIdentificationNumber(dto.getIdentificationNumber());
        entity.setCustomer(customer);

        return mapToDTO(identificationRepository.save(entity));
    }

    @Override
    public List<CustomerIdentificationDTO> getAllCustomerIdentifications() {
        return identificationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerIdentificationDTO getCustomerIdentificationById(Long id) {
        return identificationRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerIdentificationDTO updateCustomerIdentification(Long id, CustomerIdentificationDTO dto) {

        CustomerIdentification existing =
                identificationRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setIdentificationType(dto.getIdentificationType());
            existing.setIdentificationNumber(dto.getIdentificationNumber());

            return mapToDTO(identificationRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Method --------

    private CustomerIdentificationDTO mapToDTO(CustomerIdentification entity) {
        CustomerIdentificationDTO dto = new CustomerIdentificationDTO();
        dto.setId(entity.getId());
        dto.setIdentificationType(entity.getIdentificationType());
        dto.setIdentificationNumber(entity.getIdentificationNumber());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
