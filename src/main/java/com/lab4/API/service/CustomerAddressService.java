package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerAddressDTO;

public interface CustomerAddressService {

    CustomerAddressDTO createCustomerAddress(CustomerAddressDTO dto);

    List<CustomerAddressDTO> getAllCustomerAddresses();

    CustomerAddressDTO getCustomerAddressById(Long id);

    CustomerAddressDTO updateCustomerAddress(Long id, CustomerAddressDTO dto);
}
