package com.fdmgroup.FdmTrianingProgramSprint4.dto;

public class PersonDTO extends CustomerDTO {
    private String dateOfBirth;
    private String phoneNumber;

    public PersonDTO(Long customerId, String name, Long addressId, String dateOfBirth, String phoneNumber) {
        super(customerId, name, addressId);
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
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
}
