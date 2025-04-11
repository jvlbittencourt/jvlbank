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
@DiscriminatorValue("SAVING")
public class SavingAccount extends Account{
    private BigDecimal monthlyIncome;

    @Override
    public boolean canWithdraw(BigDecimal amount){

        if (getBalance().compareTo(amount) >= 0)
            return true;
        return false;
    }
}
