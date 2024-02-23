package com.example.Online.Banking.System.account.controller;

import com.example.Online.Banking.System.account.dto.AccountRequest;
import com.example.Online.Banking.System.account.dto.AccountResponse;
import com.example.Online.Banking.System.account.entity.Account;
import com.example.Online.Banking.System.account.repository.AccountRepository;
import com.example.Online.Banking.System.account.service.AccountService;
import com.example.Online.Banking.System.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/account")
public class AccountController {
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {

        AccountResponse newAccount = accountService.createAccount(accountRequest);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountResponse> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping("/userid={userId}")
    public ResponseEntity<List<AccountResponse>> getAccountsByUserId(@PathVariable("userId") Long userId) {
        List<AccountResponse> allAccounts = accountService.getAccountByUserId(userId);
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @DeleteMapping("/close/{accountId}")
    public ResponseEntity<AccountResponse> closeAccount(@PathVariable() Long accountId) {
        AccountResponse account = accountService.closeAccount(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
