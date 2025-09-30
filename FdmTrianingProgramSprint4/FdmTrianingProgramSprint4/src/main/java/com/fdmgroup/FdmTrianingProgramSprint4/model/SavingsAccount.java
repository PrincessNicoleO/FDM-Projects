package com.fdmgroup.FdmTrianingProgramSprint4.model;

import jakarta.persistence.Entity;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.AccountDTO;

import jakarta.persistence.DiscriminatorValue;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SAVINGS") 
public class SavingsAccount extends Account {
    @NotNull
    private Double interestRate;

    public SavingsAccount() {}

    public SavingsAccount(Double balance, Customer customer, Double interestRate) {
        super(balance, customer); 
        this.interestRate = interestRate;
    }

    // Getters and Setters
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    // Override toDTO to include interestRate
    @Override
    public AccountDTO toDTO() {
        AccountDTO dto = super.toDTO(); // Get base DTO
        dto.setInterestRate(interestRate); // Add specific field
        return dto;
    }

    @Override
    public String toString() {
        return super.toString() + ", SavingsAccount{" +
                "interestRate=" + interestRate +
                '}';
    }
}
