package com.finance.dto;

import com.finance.dao.IncomeType;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "AppUserID")
    private Long userId;

    @Schema(description = "LocalDateTime")
    private LocalDateTime dateTime;
    @Schema(description = "LocalDateTime")
    private IncomeType incomeType;
    @Schema(description = "LocalDateTime")
    private BigDecimal amount;

    /**
     * Fluent style API fashion incomeDto builder.
     */
    public IncomeDto withAppUser(Long userId){
        this.userId = userId;
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
