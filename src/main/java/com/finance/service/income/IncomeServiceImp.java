package com.finance.service.income;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import com.finance.repository.income.IncomeRepository;
import org.springframework.stereotype.Service;
import java.util.List;


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

    public List<IncomeDto> getAllIncomes() {
        return incomeRepository.findAll()
                .stream()
                .map(incomeMapper::toDto)
                .toList();
        //Maybe we should think to return a list in service,
        // and return mono and flux objects in service? To discussion.
    }

    @Override
    public IncomeDto findIncomeById(Long id) {
        return null; //TODO
    }

    @Override
    public void createIncome(IncomeDto incomeDto) {
        Income income = new Income
                .IncomeBuilder()
                .withIncome(incomeDto.getIncome())
                .withAmount(incomeDto.getAmount())
                .withAppUser(incomeDto.getAppUser())
                .withDateTime(incomeDto.getDateTime())
                .build();
        incomeRepository.save(income);
    }

    @Override
    public IncomeDto updateIncomeById(Long id, IncomeDto incomeDto) {
        return null; //TODO
    }

    @Override
    public void deleteIncomeById(Long id) {
    }


}
