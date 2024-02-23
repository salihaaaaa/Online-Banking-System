package com.example.Online.Banking.System.account.dto;

import com.example.Online.Banking.System.account.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AccountRequest {
    private Long userId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Double initialDeposit;
}
