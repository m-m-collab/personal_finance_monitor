package com.finance.service.income;

import com.finance.dao.AppUser;
import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import com.finance.exception.rest.UserNotFoundException;
import com.finance.observer.income.IncomePublisher;
import com.finance.repository.income.AppUserRepository;
import com.finance.repository.income.IncomeRepository;
import com.finance.service.income.mapper.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;


/**
 * Income service.
 */
@Service
public class IncomeServiceImp implements IncomeService, IncomePublisher {

    private final IncomeRepository incomeRepository;
    private final AppUserRepository appUserRepository;
    private final IncomeMapper incomeMapper;

    private final List<Flow.Subscriber<? super IncomeDto>> subscribers = new CopyOnWriteArrayList<>();


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
    public Optional<IncomeDto> findIncomeById(Long id) {
        return incomeRepository.findById(id)
                .map(incomeMapper::toDto);

    }

    @Override
    public IncomeDto createIncome(IncomeDto incomeDto, Long userId) {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        Income income = incomeMapper.toEntity(incomeDto, appUser);
        Income savedIncome = incomeRepository.save(income);
        return incomeMapper.toDto(savedIncome);
    }

    @Override
    public IncomeDto updateIncomeById(Long id, IncomeDto incomeDto) {
//        Optional<Income> incomeOptional = incomeRepository.findById(id);
//        if(incomeOptional.isPresent()){
//            Income existingIncome = incomeOptional.get();
//            existingIncome.setIncomeType(incomeDto.getIncomeType());
//            existingIncome.setAmount(incomeDto.getAmount());
//            existingIncome.setAppUser(incomeDto.getAppUser());
//            existingIncome.setDateTime(incomeDto.getDateTime());
//
//            Income updatedIncome = incomeRepository.save(existingIncome);
//
//            return new IncomeDto()
//                    .withIncomeType(updatedIncome.getIncomeType())
//                    .withLocalDateTime(updatedIncome.getDateTime())
//                    .withAmount(updatedIncome.getAmount())
//                    .withAppUser(updatedIncome.getAppUser());
//        } else {
//            throw new IncomeNotFoundException("Income not found with id: " + id);
//        }
        return null;
    }

    @Override
    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public void subscribe(Flow.Subscriber<? super IncomeDto> subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(IncomeDto incomeDto) {
        subscribers.forEach(s -> s.onNext(incomeDto));
    }
}