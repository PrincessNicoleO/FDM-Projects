package com.fdmgroup.FdmTrianingProgramSprint4.dto;

public class CompanyDTO extends CustomerDTO {
    private String registrationNumber;
    private String industry;
    private String contactPerson;

    public CompanyDTO(Long customerId, String name, Long addressId, String registrationNumber, String industry, String contactPerson) {
        super(customerId, name, addressId);
        this.registrationNumber = registrationNumber;
        this.industry = industry;
        this.contactPerson = contactPerson;
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
}
