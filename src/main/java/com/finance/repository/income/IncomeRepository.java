package com.finance.repository.income;

import com.finance.dao.Income;
import com.finance.dto.IncomeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Income entities.
 */
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
