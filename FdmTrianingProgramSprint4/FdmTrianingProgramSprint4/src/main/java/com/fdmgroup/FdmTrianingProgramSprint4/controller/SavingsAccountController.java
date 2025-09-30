package com.fdmgroup.FdmTrianingProgramSprint4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.FdmTrianingProgramSprint4.model.SavingsAccount;
import com.fdmgroup.FdmTrianingProgramSprint4.service.SavingsAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Api(value = "Savings Account Management")
@RestController
@RequestMapping("/api/savingsAccounts")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @ApiOperation(value = "Create a new savings account", response = SavingsAccount.class)
    @PostMapping
    public ResponseEntity<SavingsAccount> createSavingsAccount(@Valid @RequestBody SavingsAccount savingsAccount) {
       
        SavingsAccount createdSavingsAccount = savingsAccountService.createSavingsAccount(savingsAccount);
        
      
        return new ResponseEntity<>(createdSavingsAccount, HttpStatus.CREATED);
    }
}

