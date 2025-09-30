package com.fdmgroup.FdmTrianingProgramSprint4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.FdmTrianingProgramSprint4.model.CheckingAccount;
import com.fdmgroup.FdmTrianingProgramSprint4.service.CheckingAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Api(value = "Checking Account Management")
@RestController
@RequestMapping("/api/checkingAccounts")
public class CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @ApiOperation(value = "Create a new checking account", response = CheckingAccount.class)
    @PostMapping
    public ResponseEntity<CheckingAccount> createCheckingAccount(@Valid @RequestBody CheckingAccount checkingAccount) {
        
        CheckingAccount createdCheckingAccount = checkingAccountService.createCheckingAccount(checkingAccount);
        
        
        return new ResponseEntity<>(createdCheckingAccount, HttpStatus.CREATED);
    }
}

