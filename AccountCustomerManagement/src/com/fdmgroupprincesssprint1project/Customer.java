package com.fdmgroupprincesssprint1project;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
	
	private final long CUSTOMER_ID;
	private static long nextCustomerId = 2000000;
	private String name;
	private String address;
	private List<Account> accounts;
	
	
	public Customer(String name, String address) {
		this.CUSTOMER_ID = nextCustomerId;
		nextCustomerId += 7;
		this.name = name;
		this.address = address;
		this.accounts = new ArrayList<>();
	}
		
	public void addAccount (Account account) {
			accounts.add(account);
		}
	public void removeAccount (Account account) {
		accounts.remove(account);
		
	}
	public abstract void chargeAllAccounts (double amount);
	public static long getNextCustomerId() {
		return nextCustomerId;
	}
	public static void setNextCustomerId(long nextCustomerId) {
		Customer.nextCustomerId = nextCustomerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public long getCUSTOMER_ID() {
		return CUSTOMER_ID;
		

		}

	@Override
	public String toString() {
		return "Customer [CUSTOMER_ID=" + CUSTOMER_ID + ", name=" + name + ", address=" + address + ", accounts="
				+ accounts + "]";
	}

	
	
	
	
	
	
}
