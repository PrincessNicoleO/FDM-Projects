package com.fdmgroup.FdmTrianingProgramSprint4.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Person extends Customer {

    @NotNull
    private String dateOfBirth;

    private String phoneNumber;

    public Person(String name, Address address, String dateOfBirth, String phoneNumber) {
        super();
        setName(name);
        setAddress(address);
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
        super();
    }

    // Getters and Setters
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "customerId=" + getCustomerId() +
                ", name='" + getName() + '\'' +
                ", address=" + getAddress() +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
