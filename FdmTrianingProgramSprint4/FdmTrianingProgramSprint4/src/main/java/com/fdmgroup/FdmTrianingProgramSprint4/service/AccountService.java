package com.fdmgroup.FdmTrianingProgramSprint4.service;

import com.fdmgroup.FdmTrianingProgramSprint4.model.Account;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    // New Method: Get accounts by customer city
    public List<Account> getAccountsByCustomerCity(String city) {
        return accountRepository.findAccountsByCustomerCity(city);
    }
}
