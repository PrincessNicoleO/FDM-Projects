package com.fdmgroup.FdmTrianingProgramSprint4.model;

import jakarta.persistence.Entity;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.AccountDTO;

import jakarta.persistence.DiscriminatorValue;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends Account {
    @NotNull
    private Integer nextCheckNumber;

    public CheckingAccount() {}

    public CheckingAccount(Double balance, Customer customer, Integer nextCheckNumber) {
        super(balance, customer); 
        this.nextCheckNumber = nextCheckNumber;
    }

    // Getters and Setters
    public Integer getNextCheckNumber() {
        return nextCheckNumber;
    }

    public void setNextCheckNumber(Integer nextCheckNumber) {
        this.nextCheckNumber = nextCheckNumber;
    }

    // Override toDTO to include nextCheckNumber
    @Override
    public AccountDTO toDTO() {
        AccountDTO dto = super.toDTO(); // Get base DTO
        dto.setNextCheckNumber(nextCheckNumber); // Add specific field
        return dto;
    }

    @Override
    public String toString() {
        return super.toString() + ", CheckingAccount{" +
                "nextCheckNumber=" + nextCheckNumber +
                '}';
    }
}
