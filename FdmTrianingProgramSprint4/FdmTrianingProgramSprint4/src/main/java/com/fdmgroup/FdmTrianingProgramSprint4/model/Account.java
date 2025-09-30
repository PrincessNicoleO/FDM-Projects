package com.fdmgroup.FdmTrianingProgramSprint4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.FdmTrianingProgramSprint4.dto.AccountDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "ACCOUNT_TYPE") 
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    public Account() {}

    public Account(Double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    // Convert Account entity to DTO
    public AccountDTO toDTO() {
        return new AccountDTO(accountId, balance, customer.getCustomerId());
    }

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
