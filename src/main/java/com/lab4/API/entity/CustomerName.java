package com.lab4.API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_name")
public class CustomerName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameType;   // e.g., Legal, Nickname, Previous
    private String nameValue;  // actual name

    @ManyToOne
    @JoinColumn(name = "customer_identifier")
    private CustomerDetails customer;

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
