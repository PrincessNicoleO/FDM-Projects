package com.fdmgroup.FdmTrianingProgramSprint4;

import com.fdmgroup.FdmTrianingProgramSprint4.model.*;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, AccountRepository accountRepository,
                                   AddressRepository addressRepository) {
        return args -> {
            // Create Addresses
            Address address1 = new Address("13 Kenworth Street", "Toronto", "Ontario", "T3R 3E3");
            Address address2 = new Address("2 Queen Street", "Caledon", "Ontario", "R43 6Y6");
            addressRepository.saveAll(List.of(address1, address2));

            // Create Customers
            Customer person = new Person("John", address2, "1990-01-01", "555-1234");
            Customer company = new Company("FDM", address1, "123456789", "Technology", "Jane Doe");
            customerRepository.saveAll(List.of(person, company));

            // Create Accounts
            Account savingsAccount = new SavingsAccount(2300.0, company, 4.5);
            Account checkingAccount1 = new CheckingAccount(45000.0, person, 1);
            Account checkingAccount2 = new CheckingAccount(120.0, company, 2);
            accountRepository.saveAll(List.of(savingsAccount, checkingAccount1, checkingAccount2));

            System.out.println("Preloaded data into the database successfully!");
        };
    }
}

