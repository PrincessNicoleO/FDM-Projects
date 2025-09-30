package com.fdmgroup.FdmTrianingProgramSprint4.controller;

import com.fdmgroup.FdmTrianingProgramSprint4.model.Account;
import com.fdmgroup.FdmTrianingProgramSprint4.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    // New Endpoint: List accounts by customer city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Account>> getAccountsByCustomerCity(@PathVariable String city) {
        List<Account> accounts = accountService.getAccountsByCustomerCity(city);
        return ResponseEntity.ok(accounts);
    }
}
