package com.lab4.API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_identification")
public class CustomerIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificationType;   // e.g., PAN, Aadhaar
    private String identificationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_identifier")
    private CustomerDetails customer;

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
