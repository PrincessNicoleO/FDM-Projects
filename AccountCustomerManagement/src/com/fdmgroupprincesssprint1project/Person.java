package com.fdmgroupprincesssprint1project;

public class Person extends Customer {

	public Person(String name, String address) {
		super(name, address);
		
	}

	@Override
	public void chargeAllAccounts(double amount) {
		for (Account account : getAccounts()) {
			account.withdraw(amount);
			
			
		}
		
	}

}
