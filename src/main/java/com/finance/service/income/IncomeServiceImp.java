package com.finance.service.income;

import com.finance.dao.AppUser;
import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import com.finance.exception.rest.IncomeNotFoundException;
import com.finance.exception.rest.UserNotFoundException;
import com.finance.repository.appuser.AppUserRepository;
import com.finance.repository.income.IncomeRepository;
import com.finance.service.income.mapper.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Income service.
 */
@Service
public class IncomeServiceImp implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final AppUserRepository appUserRepository;
    private final IncomeMapper incomeMapper;

    @Autowired
    public IncomeServiceImp(IncomeRepository incomeRepository,
                            AppUserRepository appUserRepository,
                            IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.appUserRepository = appUserRepository;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public List<IncomeDto> getAllIncomes() {
        return incomeRepository.findAll()
                .stream()
                .map(incomeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IncomeDto findIncomeById(Long id) {
        return incomeRepository.findById(id)
                .map(incomeMapper::toDto)
                .orElseThrow(() -> new IncomeNotFoundException("Income with id " + id + " not found"));

    }

    @Override
    public IncomeDto createIncome(IncomeDto incomeDto, Long userId) {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        Income income = incomeMapper.toDao(incomeDto, appUser);
        Income savedIncome = incomeRepository.save(income);
        return incomeMapper.toDto(savedIncome);
    }

    @Override
    public IncomeDto updateIncomeById(Long id, IncomeDto incomeDto) {

        Income incomeToUpdate = incomeRepository.findById(id)
                .orElseThrow(()-> new IncomeNotFoundException("Income not found with id: "+id));
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("App user by id: "+id+" not found"));
        Income updatedIncome = incomeMapper.toDao(incomeDto, appUser);
        Income savedIncome = incomeRepository.save(updatedIncome);
        return incomeMapper.toDto(savedIncome);
    }

    @Override
    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }

}