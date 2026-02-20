package com.lab4.API.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.lab4.API.dto.CustomerAddressDTO;
import com.lab4.API.entity.CustomerAddress;
import com.lab4.API.entity.CustomerDetails;
import com.lab4.API.repository.CustomerAddressRepository;
import com.lab4.API.repository.CustomerDetailsRepository;
import com.lab4.API.service.CustomerAddressService;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private final CustomerAddressRepository addressRepository;
    private final CustomerDetailsRepository customerRepository;

    public CustomerAddressServiceImpl(
            CustomerAddressRepository addressRepository,
            CustomerDetailsRepository customerRepository) {

        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerAddressDTO createCustomerAddress(CustomerAddressDTO dto) {

        CustomerDetails customer =
                customerRepository.findById(dto.getCustomerIdentifier())
                        .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerAddress entity = new CustomerAddress();
        entity.setAddressType(dto.getAddressType());
        entity.setAddressLine(dto.getAddressLine());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setPostalCode(dto.getPostalCode());
        entity.setEffectiveDate(dto.getEffectiveDate());
        entity.setCustomer(customer);

        return mapToDTO(addressRepository.save(entity));
    }

    @Override
    public List<CustomerAddressDTO> getAllCustomerAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerAddressDTO getCustomerAddressById(Long id) {
        return addressRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CustomerAddressDTO updateCustomerAddress(Long id, CustomerAddressDTO dto) {

        CustomerAddress existing =
                addressRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setAddressType(dto.getAddressType());
            existing.setAddressLine(dto.getAddressLine());
            existing.setCity(dto.getCity());
            existing.setState(dto.getState());
            existing.setCountry(dto.getCountry());
            existing.setPostalCode(dto.getPostalCode());
            existing.setEffectiveDate(dto.getEffectiveDate());

            return mapToDTO(addressRepository.save(existing));
        }

        return null;
    }

    // -------- Mapping Method --------

    private CustomerAddressDTO mapToDTO(CustomerAddress entity) {
        CustomerAddressDTO dto = new CustomerAddressDTO();
        dto.setId(entity.getId());
        dto.setAddressType(entity.getAddressType());
        dto.setAddressLine(entity.getAddressLine());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setCountry(entity.getCountry());
        dto.setPostalCode(entity.getPostalCode());
        dto.setEffectiveDate(entity.getEffectiveDate());
        dto.setCustomerIdentifier(entity.getCustomer().getCustomerIdentifier());
        return dto;
    }
}
