package com.example.Online.Banking.System.account.dto;

import com.example.Online.Banking.System.account.enums.AccountType;
import com.example.Online.Banking.System.account.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AccountResponse {
    private Long id;
    private Long userId;
    private Long accountNumber;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private Status status;
}
