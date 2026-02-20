package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerContactDTO;
import com.lab4.API.entity.CustomerContact;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerContactRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerContactService;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    private final CustomerContactRepository contactRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerContactServiceImpl(
            CustomerContactRepository contactRepository,
            CustomerDetailsRepository customerRepository) {

        this.contactRepository = contactRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerContactDTO createCustomerContact(CustomerContactDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerContact entity = new CustomerContact();
        entity.setContactType(dto.getContactType());
        entity.setContactValue(dto.getContactValue());
        entity.setCustomer(customer);

        return mapToDTO(contactRepository.save(entity));
    }

    @Override
    public List<CustomerContactDTO> getAllCustomerContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerContactDTO getCustomerContactById(Long id) {
        return contactRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerContactDTO updateCustomerContact(Long id, CustomerContactDTO dto) {

        CustomerContact existing =
                contactRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setContactType(dto.getContactType());
            existing.setContactValue(dto.getContactValue());

            return mapToDTO(contactRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Method --------

    private CustomerContactDTO mapToDTO(CustomerContact entity) {
        CustomerContactDTO dto = new CustomerContactDTO();
        dto.setId(entity.getId());
        dto.setContactType(entity.getContactType());
        dto.setContactValue(entity.getContactValue());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
