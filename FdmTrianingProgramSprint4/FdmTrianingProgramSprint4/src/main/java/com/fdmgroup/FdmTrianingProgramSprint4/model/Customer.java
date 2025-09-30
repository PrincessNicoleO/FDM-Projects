package com.fdmgroup.FdmTrianingProgramSprint4.model;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.CustomerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "customerType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Company.class, name = "company"),
    @JsonSubTypes.Type(value = Person.class, name = "person")
})
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", initialValue = 1001, allocationSize = 1)
    private Long customerId;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @NotNull
    @JoinColumn(name = "FK_ADDRESS_ID", nullable = false)
    private Address address;

    // DTO Conversion Methods
    public CustomerDTO toDTO() {
        return new CustomerDTO(customerId, name, address.getAddressId());
    }

    public void fromDTO(CustomerDTO customerDTO, Address address) {
        this.customerId = customerDTO.getCustomerId();
        this.name = customerDTO.getName();
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }
}
