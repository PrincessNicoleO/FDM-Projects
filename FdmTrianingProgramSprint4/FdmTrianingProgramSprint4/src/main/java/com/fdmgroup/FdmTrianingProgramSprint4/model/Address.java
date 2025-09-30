package com.fdmgroup.FdmTrianingProgramSprint4.model;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.AddressDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotNull
    private String streetNumber;

    @NotNull
    private String city;

    @NotNull
    private String province;

    @NotNull
    @Size(min = 3, max = 6)
    private String postalCode;

    public Address() {}

    public Address(String streetNumber, String city, String province, String postalCode) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    // DTO Conversion Method (to DTO)
    public AddressDTO toDTO() {
        return new AddressDTO(addressId, streetNumber, city, province, postalCode);
    }

    // DTO Conversion Method (from DTO)
    public void fromDTO(AddressDTO addressDTO) {
        this.addressId = addressDTO.getAddressId(); // Optional for updates
        this.streetNumber = addressDTO.getStreetNumber();
        this.city = addressDTO.getCity();
        this.province = addressDTO.getProvince();
        this.postalCode = addressDTO.getPostalCode();
    }

    // Getters and Setters
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
