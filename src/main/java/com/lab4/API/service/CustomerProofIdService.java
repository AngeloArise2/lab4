package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerProofIdDTO;

public interface CustomerProofIdService {

    CustomerProofIdDTO createCustomerProofId(CustomerProofIdDTO dto);

    List<CustomerProofIdDTO> getAllCustomerProofIds();

    CustomerProofIdDTO getCustomerProofIdById(Long id);

    CustomerProofIdDTO updateCustomerProofId(Long id, CustomerProofIdDTO dto);
}
