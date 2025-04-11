package com.jvl.jvlbank.dto.account.account;

import java.math.BigDecimal;
import java.util.List;

import com.jvl.jvlbank.enums.AccountType;
import com.jvl.jvlbank.dto.transaction.TransactionDTO;


public class AccountResponseDTO {
    private Long id;
    private String agencyNumber;
    private String accountNumber;
    private AccountType accountType;

    private BigDecimal balance;
    private List<TransactionDTO> transactions;
}
