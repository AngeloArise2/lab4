package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerContactDTO;

public interface CustomerContactService {

    CustomerContactDTO createCustomerContact(CustomerContactDTO dto);

    List<CustomerContactDTO> getAllCustomerContacts();

    CustomerContactDTO getCustomerContactById(Long id);

    CustomerContactDTO updateCustomerContact(Long id, CustomerContactDTO dto);
}
