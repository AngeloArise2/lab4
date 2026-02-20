package com.lab4.API.dto;

import java.time.LocalDate;

public class CustomerProofIdDTO {

    private Long id;
    private String proofType;
    private String proofNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String customerIdentifier; // FK reference

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getProofNumber() {
        return proofNumber;
    }

    public void setProofNumber(String proofNumber) {
        this.proofNumber = proofNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }
}
