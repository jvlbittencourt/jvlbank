package com.jvl.jvlbank.dto.account.account;

import java.math.BigDecimal;

import com.jvl.jvlbank.enums.AccountType;

import lombok.Data;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class AccountCreateDTO {

    @NotBlank
    private String agencyNumber;
    
    @NotBlank
    private String acountNumber;

    @NotNull
    private AccountType accountType;
    
    @NotNull
    private Long holderId;
    
    @NotNull
    @DecimalMin(value = "0.00", message = "Initial balance must be positive.")
    private BigDecimal initialBalance;

    
    
}
