package com.finance.service;

import com.finance.dto.Income;
import com.finance.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Income service.
 */
@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(Income income){
        return incomeRepository.save(income);
    }

    public List<Income> findAllIncomes(){
        return incomeRepository.findAll();
    }
}
