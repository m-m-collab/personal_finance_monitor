package com.finance.dto;

import com.finance.dao.AppUser;
import com.finance.dao.Income;
import com.finance.dao.IncomeType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data transfer object of the income.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper =false)
@ToString(callSuper = false)
public class IncomeDto {

    private Long id;

    private AppUser appUser;

    private LocalDateTime dateTime;

    private IncomeType incomeType;

    private BigDecimal amount;

    /**
     * Fluent style API fashion incomeDto builder.
     */

    public IncomeDto withAppUser(AppUser appUser){
        this.appUser = appUser;
        return this;
    }

    public IncomeDto withLocalDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
        return this;
    }

    public IncomeDto withIncomeType(IncomeType incomeType){
        this.incomeType = incomeType;
        return this;
    }

    public IncomeDto withAmount(BigDecimal amount){
        this.amount = amount;
        return this;
    }
}
