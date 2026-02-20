package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerClassification;

public interface CustomerClassificationRepository
        extends JpaRepository<CustomerClassification, Long> {
}
