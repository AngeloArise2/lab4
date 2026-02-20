package com.lab4.API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_classification")
public class CustomerClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classificationType;
    private String classificationValue;

    @ManyToOne
    @JoinColumn(name = "customer_identifier")
    private CustomerDetails customer;

    public Long getId() {
        return id;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getClassificationValue() {
        return classificationValue;
    }

    public void setClassificationValue(String classificationValue) {
        this.classificationValue = classificationValue;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
