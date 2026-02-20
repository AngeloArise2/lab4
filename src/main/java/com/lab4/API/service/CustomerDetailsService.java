package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerDetailsDTO;

public interface CustomerDetailsService {

    CustomerDetailsDTO createCustomer(CustomerDetailsDTO customerDTO);

    List<CustomerDetailsDTO> getAllCustomers();

    CustomerDetailsDTO getCustomerById(String id);

    CustomerDetailsDTO updateCustomer(String id, CustomerDetailsDTO customerDTO);
}
