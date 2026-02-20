package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerClassificationDTO;
import com.lab4.API.entity.CustomerClassification;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerClassificationRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerClassificationService;

@Service
public class CustomerClassificationServiceImpl implements CustomerClassificationService {

    private final CustomerClassificationRepository classificationRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerClassificationServiceImpl(
            CustomerClassificationRepository classificationRepository,
            CustomerDetailsRepository customerRepository) {

        this.classificationRepository = classificationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerClassificationDTO createCustomerClassification(CustomerClassificationDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerClassification entity = new CustomerClassification();
        entity.setClassificationType(dto.getClassificationType());
        entity.setClassificationValue(dto.getClassificationValue());
        entity.setCustomer(customer);

        return mapToDTO(classificationRepository.save(entity));
    }

    @Override
    public List<CustomerClassificationDTO> getAllCustomerClassifications() {
        return classificationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerClassificationDTO getCustomerClassificationById(Long id) {
        return classificationRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerClassificationDTO updateCustomerClassification(Long id, CustomerClassificationDTO dto) {

        CustomerClassification existing =
                classificationRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setClassificationType(dto.getClassificationType());
            existing.setClassificationValue(dto.getClassificationValue());

            return mapToDTO(classificationRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Method --------

    private CustomerClassificationDTO mapToDTO(CustomerClassification entity) {
        CustomerClassificationDTO dto = new CustomerClassificationDTO();
        dto.setId(entity.getId());
        dto.setClassificationType(entity.getClassificationType());
        dto.setClassificationValue(entity.getClassificationValue());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
