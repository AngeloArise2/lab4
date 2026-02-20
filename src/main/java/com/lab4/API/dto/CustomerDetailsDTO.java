package com.lab4.API.dto;

import java.time.LocalDate;

public class CustomerDetailsDTO {

    private String customerIdentifier;
    private String customerFullName;
    private String customerGender;
    private String customerType;
    private LocalDate customerDateOfBirth;
    private String customerPreferredLanguage;
    private String customerStatus;
    private String customerCountryOfOrigin;

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public LocalDate getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerPreferredLanguage() {
        return customerPreferredLanguage;
    }

    public void setCustomerPreferredLanguage(String customerPreferredLanguage) {
        this.customerPreferredLanguage = customerPreferredLanguage;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerCountryOfOrigin() {
        return customerCountryOfOrigin;
    }

    public void setCustomerCountryOfOrigin(String customerCountryOfOrigin) {
        this.customerCountryOfOrigin = customerCountryOfOrigin;
    }
}
