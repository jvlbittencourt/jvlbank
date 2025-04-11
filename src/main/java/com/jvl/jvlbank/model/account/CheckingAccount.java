package com.jvl.jvlbank.model.account;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("CHEKCING")
public class CheckingAccount extends Account{

    private BigDecimal overdraftLimit;
    private BigDecimal maintenanceFee;

    @Override
    public boolean canWithdraw(BigDecimal amount){
        var limit = getBalance().add(overdraftLimit);

        if (getBalance().compareTo(amount) >= 0 || limit.compareTo(amount) >= 0)
            return true;
        return false;
    }
}
