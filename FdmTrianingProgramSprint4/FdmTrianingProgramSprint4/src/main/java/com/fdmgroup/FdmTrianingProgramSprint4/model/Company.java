package com.fdmgroup.FdmTrianingProgramSprint4.model;

import jakarta.persistence.Entity;

@Entity
public class Company extends Customer {

    private String registrationNumber;
    private String industry;
    private String contactPerson;

    // Constructor to match the DataLoader instantiation
    public Company(String name, Address address, String registrationNumber, String industry, String contactPerson) {
        super();
        setName(name);           // Inherited from Customer class
        setAddress(address);     // Inherited from Customer class
        this.registrationNumber = registrationNumber;
        this.industry = industry;
        this.contactPerson = contactPerson;
    }

    // Default constructor
    public Company() {
        super();
    }

    // Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString() {
        return "Company{" +
                "customerId=" + getCustomerId() +
                ", name='" + getName() + '\'' +
                ", address=" + getAddress() +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", industry='" + industry + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }
}
