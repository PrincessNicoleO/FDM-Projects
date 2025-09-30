package com.fdmgroup.FdmTrianingProgramSprint4.dto;

public class AccountDTO {
    private Long accountId;
    private Double balance;
    private Long customerId;
    private Double interestRate; // For SavingsAccount
    private Integer nextCheckNumber; // For CheckingAccount

    public AccountDTO() {}

    public AccountDTO(Long accountId, Double balance, Long customerId) {
        this.accountId = accountId;
        this.balance = balance;
        this.customerId = customerId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getNextCheckNumber() {
        return nextCheckNumber;
    }

    public void setNextCheckNumber(Integer nextCheckNumber) {
        this.nextCheckNumber = nextCheckNumber;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", customerId=" + customerId +
                ", interestRate=" + interestRate +
                ", nextCheckNumber=" + nextCheckNumber +
                '}';
    }
}
