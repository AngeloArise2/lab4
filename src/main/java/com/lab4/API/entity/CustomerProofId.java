package com.lab4.API.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer_proof_id")
public class CustomerProofId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proofType;      // e.g., Passport, Driving License
    private String proofNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "customer_identifier")
    private CustomerDetails customer;

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
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

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
