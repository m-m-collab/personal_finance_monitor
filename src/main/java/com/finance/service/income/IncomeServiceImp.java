package com.finance.service.income;

import com.finance.dto.IncomeDto;
import com.finance.repository.income.IncomeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Income service.
 */
@Service
public class IncomeServiceImp implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;

    public IncomeServiceImp(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

    public Flux<IncomeDto> getAllIncomes() {
        return Flux.fromIterable(incomeRepository.findAll())
                .map(incomeMapper::toDto);
        //Maybe we should think to return a list in service,
        // and return mono and flux objects in service? To discussion.
    }

    @Override
    public Mono<IncomeDto> findIncomeById(Long id) {
        return null; //TODO
    }

    @Override
    public Mono<IncomeDto> createIncome(IncomeDto incomeDto) {
        return null; //TODO
    }

    @Override
    public Mono<IncomeDto> updateIncomeById(Long id, IncomeDto incomeDto) {
        return null; //TODO
    }

    @Override
    public Mono<Void> deleteIncomeById(Long id) {
        return null; //TODO
    }

}
