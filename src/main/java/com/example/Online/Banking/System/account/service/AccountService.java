package com.example.Online.Banking.System.account.service;

import com.example.Online.Banking.System.account.dto.AccountRequest;
import com.example.Online.Banking.System.account.dto.AccountResponse;
import com.example.Online.Banking.System.account.entity.Account;
import com.example.Online.Banking.System.account.enums.Status;
import com.example.Online.Banking.System.account.repository.AccountRepository;
import com.example.Online.Banking.System.exception.AccountNotFoundException;
import com.example.Online.Banking.System.exception.IdNotFoundException;
import com.example.Online.Banking.System.user.entity.User;
import com.example.Online.Banking.System.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountResponse createAccount(AccountRequest accountRequest) {
        User user = userRepository.findById(accountRequest.getUserId())
                .orElseThrow(() -> new IdNotFoundException("Id not found"));

        Account account = new Account();

        account.setUser(user);
        account.setAccountNumber(generateRandomAccountNumber());
        account.setAccountType(accountRequest.getAccountType());
        account.setBalance(accountRequest.getInitialDeposit());
        account.setStatus(Status.ACTIVE);

        account = accountRepository.save(account);

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId(account.getId());
        accountResponse.setUserId(account.getUser().getId());
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setStatus(account.getStatus());

        return accountResponse;
    }


    public List<AccountResponse> getAllAccounts() {

        List<Account> allAccounts = accountRepository.findAll();

        if (allAccounts.isEmpty()) {
            throw new AccountNotFoundException("No account found!");
        }

        return allAccounts.stream()
                .map(this::mapToAccountResponse)
                .collect(Collectors.toList());
    }

    public List<AccountResponse> getAccountByUserId(Long userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);

        if (accounts.isEmpty()) {
            throw new AccountNotFoundException("No account found for user with id " + userId);
        }

         return accounts.stream()
                 .map(this::mapToAccountResponse)
                 .collect(Collectors.toList());
    }

    public AccountResponse getAccountByAccountNumber(Long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("No account found for account number " + accountNumber);
        }

        return mapToAccountResponse(account);
    }

    public AccountResponse closeAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("No account found for id " + accountId));

        account.setStatus(Status.INACTIVE);
        accountRepository.save(account);

        return mapToAccountResponse(account);
    }

    private AccountResponse mapToAccountResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setUserId(account.getUser().getId());
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setStatus(account.getStatus());
        return accountResponse;
    }

    private long generateRandomAccountNumber() {
        // Generate a random 10-digit account number
        return ThreadLocalRandom.current().nextLong(1_000_000_000_0L, 9_999_999_999_9L);
    }


}
