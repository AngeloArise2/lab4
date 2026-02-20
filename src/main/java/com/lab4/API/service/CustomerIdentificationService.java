package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerIdentificationDTO;

public interface CustomerIdentificationService {

    CustomerIdentificationDTO createCustomerIdentification(CustomerIdentificationDTO dto);

    List<CustomerIdentificationDTO> getAllCustomerIdentifications();

    CustomerIdentificationDTO getCustomerIdentificationById(Long id);

    CustomerIdentificationDTO updateCustomerIdentification(Long id, CustomerIdentificationDTO dto);
}
