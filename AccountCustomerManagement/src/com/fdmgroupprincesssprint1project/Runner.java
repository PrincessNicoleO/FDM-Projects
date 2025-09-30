package com.fdmgroupprincesssprint1project;

public class Runner {
	public static void main(String[]args) { 

	
		 AccountController controller = new AccountController();

		    // 1. As a bank teller I should be able to create a new customer
		    Customer person1 = controller.createCustomer("Angel Mo", "20 Stanbrook Road", "person");
		    Customer company1 = controller.createCustomer("RBC", "100 bishopsgate", "company");
		    System.out.println(controller.getCostumers());
		    System.out.println("Controller has created two customers a person and a bank company");
		    System.out.println(person1);
		    System.out.println( company1);
		   

		    // 2. As a bank teller I should be able to delete an existing customer
		    System.out.println("Controller deleting exsisting customer");
		    controller.removeCustomer(person1);
		    System.out.println(controller.getCostumers());
		    System.out.println("The person has been removed");
		    controller.removeCustomer(company1);
		    System.out.println(controller.getCostumers());
		    System.out.println("And now the company has been removed too");
		    
		 // 3. As a bank teller I should be able to create a new account for a customer
		    Customer person2 = controller.createCustomer("Esther Smith", "123 sweet avenue", "person");
		    Customer company2 = controller.createCustomer("Nandos", "123 Stratford Road", "company");
		    System.out.println(controller.getCostumers());
		    Account savingAccount = controller.createAccount(person2, "savings");
		    Account checkingAccount = controller.createAccount(company2, "checking");
		    System.out.println(controller.getAccounts());

		    System.out.println("Controller creates two new accounts");
		    System.out.println(person2.getAccounts());
		    System.out.println(company2.getAccounts());
		    
		 // 4. As a bank teller I should be able to delete an existing account for a customer
		    System.out.println("Current accounts are: " + controller.getAccounts());
		    controller.removeAccount(savingAccount);
		    System.out.println("The savings account has been removed");
		    System.out.println(controller.getAccounts());
		    controller.removeAccount(checkingAccount);
		    System.out.println("Now so has the checking");
		    System.out.println(controller.getAccounts());
		    
		//5. // As a bank teller I should be able to charge a fee from a customer's account
		    
		    System.out.println("Created two accounts for person2 and company2 each a savings and checking and deposited £100 in all their accounts");
		    Account savingAccountPerson = controller.createAccount(person2, "savings");
		    Account checkingAccountPerson = controller.createAccount(person2, "checking");

		    savingAccountPerson.deposit(100);
		    checkingAccountPerson.deposit(100);
		    
		    Account savingAccountCompany = controller.createAccount(company2, "savings");
		    Account checkingAccountCompany = controller.createAccount(company2, "checking");

		    savingAccountCompany.deposit(100);
		    checkingAccountCompany.deposit(100);
		    
		    System.out.println(controller.getCustomers());
		    
		    System.out.println("Now im charging the personal accounts £15");
		    person2.chargeAllAccounts(15);
		    System.out.println(controller.getCustomers());
		    System.out.println("Now im charging the company accounts £15");
		    company2.chargeAllAccounts(15);
		    System.out.println(controller.getCustomers());




	}
}
