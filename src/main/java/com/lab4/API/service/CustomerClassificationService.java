package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerClassificationDTO;

public interface CustomerClassificationService {

    CustomerClassificationDTO createCustomerClassification(CustomerClassificationDTO dto);

    List<CustomerClassificationDTO> getAllCustomerClassifications();

    CustomerClassificationDTO getCustomerClassificationById(Long id);

    CustomerClassificationDTO updateCustomerClassification(Long id, CustomerClassificationDTO dto);
}
