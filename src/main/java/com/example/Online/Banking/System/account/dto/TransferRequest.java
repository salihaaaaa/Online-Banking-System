package com.example.Online.Banking.System.account.dto;

import lombok.Data;

@Data
public class TransferRequest {
    private Long sourceAccountNumber;
    private Long destinationAccountNumber;
    private Double amount;
}
