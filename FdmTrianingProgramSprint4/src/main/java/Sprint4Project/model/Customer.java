package com.fdmgroup.FdmTrianingProgramSprint4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fdmgroup.FdmTrianingProgramSprint4.model.*;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.*;

@SpringBootApplication
public class FdmTrianingProgramSprint4Application {

    public static void main(String[] args) {
        SpringApplication.run(FdmTrianingProgramSprint4Application.class, args);
    }

    @Bean
    public CommandLineRunner preloadData(CustomerRepository customerRepo, AccountRepository accountRepo,
                                         AddressRepository addressRepo, SavingsAccountRepository savingsRepo,
                                         CheckingAccountRepository checkingRepo) {
        return args -> {
            // Preload Address data
        	Address address1 = new Address("13 KENWORTH STREET", "T3R 3E3", "TORONTO", "ONTARIO");
        	Address address2 = new Address("2 QUEEN STREET", "R43 6Y6", "CALEDON", "ONTARIO");
        	addressRepo.save(address1);
        	addressRepo.save(address2);


            // Preload Customer data
            Company companyCustomer = new Company("FDM", address1, "5550125", "Finance", "Jackie Hill");
            Person personCustomer = new Person("JOHN", address2, "16/05/2000", "07544114424");
            customerRepo.save(companyCustomer);
            customerRepo.save(personCustomer);


            // Preload Account data
            Account account1 = new SavingsAccount(2300.0, personCustomer, 4.5);
            Account account2 = new SavingsAccount(45000.0, companyCustomer, 5.0);
            Account account3 = new CheckingAccount(120.0, personCustomer, 1);
            accountRepo.save(account1);
            accountRepo.save(account2);
            accountRepo.save(account3);

            // Save specialized accounts
            savingsRepo.save((SavingsAccount) account1);
            savingsRepo.save((SavingsAccount) account2);
            checkingRepo.save((CheckingAccount) account3);

            System.out.println("Preloaded data!");
        };
    }
}
