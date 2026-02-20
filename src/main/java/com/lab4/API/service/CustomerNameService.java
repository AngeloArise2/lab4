package com.lab4.API.service;

import java.util.List;
import com.lab4.API.dto.CustomerNameDTO;

public interface CustomerNameService {

    CustomerNameDTO createCustomerName(CustomerNameDTO dto);

    List<CustomerNameDTO> getAllCustomerNames();

    CustomerNameDTO getCustomerNameById(Long id);

    CustomerNameDTO updateCustomerName(Long id, CustomerNameDTO dto);
}
