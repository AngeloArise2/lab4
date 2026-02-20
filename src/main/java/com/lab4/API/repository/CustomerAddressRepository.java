package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerAddress;

public interface CustomerAddressRepository
        extends JpaRepository<CustomerAddress, Long> {
}
