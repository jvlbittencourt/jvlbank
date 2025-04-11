package com.jvl.jvlbank.dto.account.checking;

import java.math.BigDecimal;

import com.jvl.jvlbank.dto.account.account.AccountResponseDTO;

import jakarta.validation.constraints.NotNull;

public class CheckingResponseDTO extends AccountResponseDTO{
    
    @NotNull
    private BigDecimal overdraftLimit;
    
    @NotNull
    private BigDecimal maintenanceFee;
}
