package com.lab4.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab4.API.entity.CustomerProofId;

public interface CustomerProofIdRepository
        extends JpaRepository<CustomerProofId, Long> {
}
