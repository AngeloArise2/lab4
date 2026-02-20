package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerName;

public interface CustomerNameRepository
        extends JpaRepository<CustomerName, Long> {
}
