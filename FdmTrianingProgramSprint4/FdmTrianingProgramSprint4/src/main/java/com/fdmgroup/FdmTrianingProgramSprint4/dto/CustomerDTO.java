package com.fdmgroup.FdmTrianingProgramSprint4.dto;


public class CustomerDTO {
    private Long customerId;
    private String name;
    private Long addressId; // Address reference, just the ID

    public CustomerDTO(Long customerId, String name, Long addressId) {
        this.customerId = customerId;
        this.name = name;
        this.addressId = addressId;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
