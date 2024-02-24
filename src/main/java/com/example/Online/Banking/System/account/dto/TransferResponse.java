package com.example.Online.Banking.System.account.dto;

import com.example.Online.Banking.System.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferResponse {
    private long sourceAccount;
    private long destinationAccount;
    private Double sourceAccountBalance;
}
