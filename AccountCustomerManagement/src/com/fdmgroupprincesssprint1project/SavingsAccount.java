package com.fdmgroupprincesssprint1project;

public class SavingsAccount extends Account {
	private double interestRate;

	public void addInterest() {
		double interestDue = (balance * interestRate / 100);
		balance += interestDue;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + "]";
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double withdraw(double amount) {
		if (amount > balance) {
			return 0;
			}
		balance -= amount;
		return amount;
	}
	}


