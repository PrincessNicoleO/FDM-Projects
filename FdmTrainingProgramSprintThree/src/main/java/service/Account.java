package service;

public class Account {
    private Long customerId;
    private String accountNumber;
    private double balance;
    private double minimumBalance;
    private double lastTransactionAmount;

    public Account(Long customerId, String accountNumber, double balance, double minimumBalance, double lastTransactionAmount) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.lastTransactionAmount = lastTransactionAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getminimumBalance() {
        return minimumBalance;
    }
    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public boolean isBelowMinimumBalance() {
        return balance < minimumBalance;
    }
    public double getLastTransactionAmount() {
        return lastTransactionAmount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "customerId=" + customerId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", minimumBalance=" + minimumBalance +
                '}';
    }
    
}

