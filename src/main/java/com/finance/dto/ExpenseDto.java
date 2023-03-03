package com.finance.dto;

import com.finance.dao.AppUser;
import com.finance.dao.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data transfer object of the expense.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

    private Long id;

    private AppUser appUser;

    private LocalDateTime dateTime;

    private Expense expense;

    private BigDecimal amount;

}
