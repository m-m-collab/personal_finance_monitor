package com.finance.dto;

import com.finance.dao.AppUser;
import com.finance.dao.Income;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data transfer object of the income.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {

    private Long id;

    private AppUser appUser;

    private LocalDateTime dateTime;

    private Income income;

    private BigDecimal amount;
}
