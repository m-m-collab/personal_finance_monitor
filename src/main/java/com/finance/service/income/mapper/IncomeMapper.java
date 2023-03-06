package com.finance.service.income.mapper;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;

/**
 * Income mapper DTO<->DAO service interface.
 */
public interface IncomeMapper {
    IncomeDto toDto(Income income);
    Income toEntity(IncomeDto incomeDto);
}
