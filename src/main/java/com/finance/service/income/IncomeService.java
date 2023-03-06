package com.finance.service.income;

import com.finance.dto.IncomeDto;
import java.util.List;
import java.util.Optional;

/**
 * Income service interface.
 */
public interface IncomeService {

    List<IncomeDto> getAllIncomes();

    Optional<IncomeDto> findIncomeById(Long id);

    IncomeDto createIncome(IncomeDto incomeDto, Long userId);

    IncomeDto updateIncomeById(Long id, IncomeDto incomeDto);

    void deleteIncomeById(Long id);
}
