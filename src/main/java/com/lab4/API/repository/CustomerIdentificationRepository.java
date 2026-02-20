package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerIdentification;

public interface CustomerIdentificationRepository
        extends JpaRepository<CustomerIdentification, Long> {
}
