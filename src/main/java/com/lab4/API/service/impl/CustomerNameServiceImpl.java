package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerNameDTO;
import com.lab4.API.entity.CustomerName;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerNameRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerNameService;

@Service
public class CustomerNameServiceImpl implements CustomerNameService {

    private final CustomerNameRepository nameRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerNameServiceImpl(CustomerNameRepository nameRepository,
                                   CustomerDetailsRepository customerRepository) {
        this.nameRepository = nameRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerNameDTO createCustomerName(CustomerNameDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerName entity = new CustomerName();
        entity.setNameType(dto.getNameType());
        entity.setNameValue(dto.getNameValue());
        entity.setCustomer(customer);

        return mapToDTO(nameRepository.save(entity));
    }

    @Override
    public List<CustomerNameDTO> getAllCustomerNames() {
        return nameRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerNameDTO getCustomerNameById(Long id) {
        return nameRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerNameDTO updateCustomerName(Long id, CustomerNameDTO dto) {

        CustomerName existing =
                nameRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setNameType(dto.getNameType());
            existing.setNameValue(dto.getNameValue());

            return mapToDTO(nameRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Methods --------

    private CustomerNameDTO mapToDTO(CustomerName entity) {
        CustomerNameDTO dto = new CustomerNameDTO();
        dto.setId(entity.getId());
        dto.setNameType(entity.getNameType());
        dto.setNameValue(entity.getNameValue());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
