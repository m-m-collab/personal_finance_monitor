package com.finance.service.income;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import org.springframework.stereotype.Service;

/**
 * Income mapper DTO<->DAO service.
 */

@Service
public interface IncomeMapper {
    IncomeDto toDto(Income income);
    Income toEntity(IncomeDto incomeDto);
}
