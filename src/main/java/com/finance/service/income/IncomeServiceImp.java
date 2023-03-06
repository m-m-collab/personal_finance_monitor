package com.finance.service.income;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import com.finance.exception.IncomeNotFoundException;
import com.finance.repository.income.IncomeRepository;
import com.finance.service.income.mapper.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * Income service.
 */
@Service
public class IncomeServiceImp implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;

    @Autowired
    public IncomeServiceImp(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public Flux<IncomeDto> getAllIncomes() {
        return incomeRepository.findAll()
                .map(incomeMapper::toDto);
    }

    @Override
    public Mono<IncomeDto> findIncomeById(Long id) {
        return incomeRepository.findById(id)
                .switchIfEmpty(Mono.error(new IncomeNotFoundException("Income not found id "+id)))
                .map(incomeMapper::toDto);
    }

    @Override
    public Mono<IncomeDto> createIncome(IncomeDto incomeDto) {
        Income income = new Income
                .IncomeBuilder()
                .withIncome(incomeDto.getIncomeType())
                .withAmount(incomeDto.getAmount())
                .withAppUser(incomeDto.getAppUser())
                .withDateTime(incomeDto.getDateTime())
                .build();

        return incomeRepository.save(income)
                .map(
                        savedIncome -> new IncomeDto()
                        .withIncomeType(savedIncome.getIncomeType())
                        .withLocalDateTime(savedIncome.getDateTime())
                        .withAmount(savedIncome.getAmount())
                        .withAppUser(savedIncome.getAppUser())
                );
    }

    @Override
    public Mono<IncomeDto> updateIncomeById(Long id, IncomeDto incomeDto) {
        return incomeRepository.findById(id)
                .flatMap(existingIncome ->
                        {
                        existingIncome.setIncomeType(incomeDto.getIncomeType());
                        existingIncome.setAmount(incomeDto.getAmount());
                        existingIncome.setAppUser(incomeDto.getAppUser());
                        existingIncome.setDateTime(incomeDto.getDateTime());
                    return  incomeRepository.save(existingIncome).thenReturn(existingIncome);
                }
                )
                .map(incomeMapper::toDto);
    }

    @Override
    public Mono<Void> deleteIncomeById(Long id) {
        return incomeRepository.deleteById(id);
    }


}
