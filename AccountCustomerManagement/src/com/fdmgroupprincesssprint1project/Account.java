package com.fdmgroupprincesssprint1project;

public abstract class Account {

	private final long ACCOUNT_ID;
	private static long nextAccountId = 1000;
	protected double balance;

	public Account() {
		this.ACCOUNT_ID = nextAccountId;
		nextAccountId += 5;
	} 
	public double withdraw (double amount) {
		balance -= amount;
		return amount;			

	}
	public void deposit (double amount) {
		balance += amount;
	}
	public void correctBalance (double newBalance) {
		balance = newBalance;
		System.out.println("Your new balance is"+ balance);


	}
	@Override
	public String toString() {
		return "Account [ACCOUNT_ID=" + ACCOUNT_ID + ", balance=" + balance + "]";
	}
	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}}

