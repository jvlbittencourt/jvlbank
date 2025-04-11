package com.jvl.jvlbank.dto.account.saving;

import java.math.BigDecimal;

import com.jvl.jvlbank.dto.account.account.AccountCreateDTO;

import jakarta.validation.constraints.NotNull;

public class SavingAccountCreateDTO extends AccountCreateDTO{
    
    @NotNull
    private BigDecimal monthlyIncome;
}
