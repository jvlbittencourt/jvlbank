package com.jvl.jvlbank.model;

import java.math.BigDecimal;
import java.util.List;

import com.jvl.jvlbank.enums.AccountType;

import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String agencyNumber;
    private String accountNumber;
    private AccountType type;
    private Client holder;
    private BigDecimal balance;
    private List<Transaction> transaction;
}
