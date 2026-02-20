package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerDetails;

public interface CustomerDetailsRepository
        extends JpaRepository<CustomerDetails, String> {
}
