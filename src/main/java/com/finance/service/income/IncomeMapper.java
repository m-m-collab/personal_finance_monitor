package com.finance.service.income;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import org.mapstruct.Mapper;

/**
 * Income mapper DTO<->DAO service.
 */

@Mapper
public interface IncomeMapper {
    IncomeDto toDto(Income income);
    Income toEntity(IncomeDto incomeDto);
}
