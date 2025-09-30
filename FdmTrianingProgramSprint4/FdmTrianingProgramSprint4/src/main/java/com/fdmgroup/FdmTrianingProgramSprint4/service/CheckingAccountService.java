package com.fdmgroup.FdmTrianingProgramSprint4.service;

import com.fdmgroup.FdmTrianingProgramSprint4.model.CheckingAccount;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    // Create a new Checking Account
    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        return checkingAccountRepository.save(checkingAccount); // Save to the database and return the saved account
    }
}
