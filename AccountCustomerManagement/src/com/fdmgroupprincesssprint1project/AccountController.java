package com.fdmgroupprincesssprint1project;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
	private List<Customer> customers;
	private List<Account> accounts; 

	public Customer createCustomer(String name, String address, String type) {
		Customer customer = null;

		switch (type.toLowerCase()) {
		case "person":
			customer = new Person(name, address);
			break;
		case "company":
			customer = new Company(name, address);
			break;
		default:
			System.out.println("Type invalid, please enter Company or Person");

		}
		customers.add(customer);
		return customer;

	}

	public Account createAccount(Customer customer, String type) {
		Account account = null;

		switch (type.toLowerCase()) {

		case "checking":
			account = new CheckingAccount();
			break;
		case "savings":
			account = new SavingsAccount();
			break;
		default:
			System.out.println("Type invalid, please enter Company or Person");
		}
		accounts.add(account);
		customer.addAccount(account);
		return account;

	}

	public void removeCustomer(Customer customer) {
		customers.remove(customer);
		for (Account account : customer.getAccounts()) {
			accounts.remove(account);

		}

	}

	public void removeAccount(Account account) {
		accounts.remove(account);
		for (Customer customer : customers) {
			customer.removeAccount(account);

		}

	}

	public List<Customer> getCostumers() {
		return customers;

	}

	public void setCostumers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}

	public AccountController() {
		customers =  new ArrayList<>();
		accounts = new ArrayList<>();
	}
}
