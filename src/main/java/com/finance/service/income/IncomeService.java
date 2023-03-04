package com.finance.service.income;

import com.finance.dto.IncomeDto;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Income service interface.
 */
public interface IncomeService {

    List<IncomeDto> getAllIncomes();

    IncomeDto findIncomeById(Long id);

    void createIncome(IncomeDto incomeDto);

    IncomeDto updateIncomeById(Long id, IncomeDto incomeDto);

    void deleteIncomeById(Long id);
}
