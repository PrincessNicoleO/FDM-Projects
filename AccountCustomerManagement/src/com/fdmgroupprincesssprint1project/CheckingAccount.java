package com.fdmgroupprincesssprint1project;

public class CheckingAccount extends Account {
	private int nextCheckNumber = 1;
	
	public CheckingAccount () {
	
	}
	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	public int getNextCheckNumber() {
		
		return nextCheckNumber ++;
			}
	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + ", balance=" + balance + "]";
	}}
