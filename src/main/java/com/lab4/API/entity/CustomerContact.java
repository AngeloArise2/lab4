package com.lab4.API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_contact")
public class CustomerContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactType;   // e.g., Email, Mobile, Office
    private String contactValue;  // actual phone/email

    @ManyToOne
    @JoinColumn(name = "customer_identifier")
    private CustomerDetails customer;

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
