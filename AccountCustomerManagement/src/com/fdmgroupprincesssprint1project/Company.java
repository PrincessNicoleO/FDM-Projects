package com.fdmgroupprincesssprint1project;

public class Company extends Customer {

	public Company(String name, String address) {
		super(name, address);

	}

	@Override
	public void chargeAllAccounts(double amount) {
		for (Account account : getAccounts()) {
			switch (account) {
			case CheckingAccount checkingAccount -> checkingAccount.withdraw(amount);
			case SavingsAccount savingsAccounts -> savingsAccounts.withdraw(amount * 2);

			default -> throw new IllegalArgumentException("Unexpected value");
			}

		}

	}

}
