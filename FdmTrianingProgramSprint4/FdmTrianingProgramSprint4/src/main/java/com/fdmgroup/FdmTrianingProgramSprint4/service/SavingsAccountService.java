package com.fdmgroup.FdmTrianingProgramSprint4.service;

import com.fdmgroup.FdmTrianingProgramSprint4.model.SavingsAccount;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountService {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    // Create a new Savings Account
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    // Get all Savings Accounts
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountRepository.findAll();
    }

    // Get Savings Account by ID
    public SavingsAccount getSavingsAccountById(Long id) {
        Optional<SavingsAccount> savingsAccount = savingsAccountRepository.findById(id);
        return savingsAccount.orElse(null); // Return null if not found
    }

    // Update an existing Savings Account
    public SavingsAccount updateSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    // Delete Savings Account by ID
    public boolean deleteSavingsAccount(Long id) {
        if (savingsAccountRepository.existsById(id)) {
            savingsAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
