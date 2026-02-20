package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerProofIdDTO;
import com.lab4.API.entity.CustomerProofId;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerProofIdRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerProofIdService;

@Service
public class CustomerProofIdServiceImpl implements CustomerProofIdService {

    private final CustomerProofIdRepository proofRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerProofIdServiceImpl(
            CustomerProofIdRepository proofRepository,
            CustomerDetailsRepository customerRepository) {

        this.proofRepository = proofRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerProofIdDTO createCustomerProofId(CustomerProofIdDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerProofId entity = new CustomerProofId();
        entity.setProofType(dto.getProofType());
        entity.setProofNumber(dto.getProofNumber());
        entity.setIssueDate(dto.getIssueDate());
        entity.setExpiryDate(dto.getExpiryDate());
        entity.setCustomer(customer);

        return mapToDTO(proofRepository.save(entity));
    }

    @Override
    public List<CustomerProofIdDTO> getAllCustomerProofIds() {
        return proofRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerProofIdDTO getCustomerProofIdById(Long id) {
        return proofRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerProofIdDTO updateCustomerProofId(Long id, CustomerProofIdDTO dto) {

        CustomerProofId existing =
                proofRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setProofType(dto.getProofType());
            existing.setProofNumber(dto.getProofNumber());
            existing.setIssueDate(dto.getIssueDate());
            existing.setExpiryDate(dto.getExpiryDate());

            return mapToDTO(proofRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Method --------

    private CustomerProofIdDTO mapToDTO(CustomerProofId entity) {
        CustomerProofIdDTO dto = new CustomerProofIdDTO();
        dto.setId(entity.getId());
        dto.setProofType(entity.getProofType());
        dto.setProofNumber(entity.getProofNumber());
        dto.setIssueDate(entity.getIssueDate());
        dto.setExpiryDate(entity.getExpiryDate());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
