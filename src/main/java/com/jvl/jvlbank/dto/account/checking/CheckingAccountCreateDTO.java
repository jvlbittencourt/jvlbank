package com.jvl.jvlbank.dto.account.checking;

import java.math.BigDecimal;

import com.jvl.jvlbank.dto.account.account.AccountCreateDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckingAccountCreateDTO extends AccountCreateDTO{

        @NotNull
        private BigDecimal overdraftLimit;
        
        @NotNull
        private BigDecimal maintenanceFee;
    
}
