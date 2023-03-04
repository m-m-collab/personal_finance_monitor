package com.finance.service.income.mapper;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import org.springframework.stereotype.Service;


/**
 * Income mapper DTO<->DAO service.
 */
@Service
public class IncomeMapperIml implements IncomeMapper {


    @Override
    public IncomeDto toDto(Income income) {
        return new IncomeDto()
                    .withAmount(income.getAmount())
                        .withIncomeType(income.getIncomeType())
                            .withLocalDateTime(income.getDateTime())
                                .withAppUser(income.getAppUser());
    }

    @Override
    public Income toEntity(IncomeDto incomeDto) {
        return null;
    }
}
