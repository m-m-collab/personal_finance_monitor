package com.finance.service.income;

import com.finance.dto.IncomeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Income service interface.
 */
public interface IncomeService {

    Flux<IncomeDto> getAllIncomes();

    Mono<IncomeDto> findIncomeById(Long id);

    Mono<IncomeDto> createIncome(IncomeDto incomeDto);

    Mono<IncomeDto> updateIncomeById(Long id, IncomeDto incomeDto);

    Mono<Void> deleteIncomeById(Long id);
}
