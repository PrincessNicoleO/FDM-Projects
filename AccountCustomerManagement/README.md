Epic: Account and customer management 
UML 
Douwivoidd_LipS
 Stories 
1. As a bank teller I should be able to create a new customer 
a. “Customer class” specifications:  
i. 
CUSTOMER_ID – is constant and unique. Customer should auto-generate the ids starting 
with the value 2_000_000 and increments by 7. The CUSTOMER_ID should be automatically 
5 
Copyright © 2024 FDM Group. 
initialized when a new customer is created. CUSTOMER_ID should not be passed in as 
arguments to the constructors. 
ii. 
iii. 
Other Attributes - Name, Address and List of accounts 
1. Create getter/setter methods for all 
Constructor – customer’s name and address should be set when the customxer is created.  
iv. addAccount() – takes in an Account and adds it to the list of accounts stored within the 
customer. 
v. removeAccount() – takes in an Account and removes it to the list of accounts stored within 
the customer. 
vi. Customer should not be instantiated and only exist as a specific type like Person or 
Company 
b. “Account Controller class” specifications: 
i. 
ii. 
iii. 
In ‘controller’ create the “AccountContoller” class 
Attributes- List of customers  
1. Create getter/setter methods 
createCustomer() – takes in the customer’s name, address, and customer type.  
1. IF the value for customer type is ‘person’ the method creates a new “Person” with 
the corresponding name and address, adds the object to the list of ‘customers’ and 
returns the “Person”  
2. IF the value for customer type is ‘company’ the method creates a new “Company” 
with the corresponding name and address, adds the object to the list of 
‘customers’ and returns the “Company”  
iv. getCustomers() – should return a list of all customers 
2. As a bank teller I should be able to delete an existing customer  
a. “Account Controller class” specifications: 
i. 
removeCustomer() - takes in a “Customer” and removes it from the “AccountContoller” list 
of ‘customers’ and removes all of the “Customer” ‘accounts’ from the “AccountController” 
list of ‘accounts’. 
3. As a bank teller I should be able to create a new account for a customer 
a. “Account” specifications: 
i. 
ii. 
iii. 
ACCOUNT_ID – is constant and unique. The class should auto-generate the ids starting with 
the value 1_000 and increments by 5. The ACCOUNT_ID should be automatically initialized 
when a new account is created. ACCOUNT_ID’s should not be passed in as arguments to the 
constructors. 
Other Attributes - Balance 
1. Create getter/setter methods for all 
deposit() - increases the account’s balance by the value of the argument passed in 
iv. withdraw() - reduces the account’s balance by the value of the argument passed in. And, 
returning the value of the argument. Account is able to be overdrawn. 
v. correctBalance() – changes the balance to match the value passed in as an argument 
vi. Account should not be instantiated and only exist as a specific type like SavingsAccount or 
CheckingAccount 
1. “SavingsAccount” specifications:  
a. Attributes- interestRate 
i. 
Create getter/setter methods 
b. withdraw() – should not be allowed to overdraw. IF the amount to 
withdraw is larger than the balance, nothing should be deducted and 0 
should be returned.  
6 
Copyright © 2024 FDM Group. 
c. 
addInterest() - calculates the interest due on the account and adds it to 
the balance. Interest due =  balance * interest rate / 100. 
2. “CheckingAccount” specifications:  
a. Attributes- nextCheckNumber 
i. 
Create getter/setter methods 
b. getNextCheckNumber() – returns the value of the nextCheckNumber. 
Check numbers start at 1 and increments by 1. 
b. “AccountController” specifications:  
i. 
ii. 
createAccount() – takes in a “Customer” and the account type. 
1. IF the value for account type is ‘checking’ the method creates a new 
“CheckingAccount”, adds the object to the “AccountController” list of ‘accounts’ 
and the “Customer” list of ‘accounts’ and returns the “CheckingAccount”  
2. IF the value for account type is ‘savings’ the method creates a new 
“SavingsAccount”, adds the object to the “AccountController” list of ‘accounts’ and 
the “Customer” list of ‘accounts’ and returns the “SavingsAccount”  
Attributes- List of accounts  
1. Create getter/setter methods 
4. As a bank teller I should be able to delete an existing account for a customer 
a. “AccountController” specifications:  
i. 
removeAccount() - takes in an “Account” and removes it from the AccountContoller’s list of 
‘accounts’ and from all Customer’s list of ‘accounts’.  
5. As a bank teller I should be able to charge a fee from a customer’s accounts 
a. “Person” specifications:  
1. chargeAllAccounts() – subtracts the amount passed in from each account that 
person holds.   
b. “Company” specifications:  
1. chargeAllAccounts()– subtracts the amount passed in from all of the company’s 
“CheckingAccount”s. Doubles the amount passed in and subtracts doubled amount 
for the company’s “SavingsAccount”s 
