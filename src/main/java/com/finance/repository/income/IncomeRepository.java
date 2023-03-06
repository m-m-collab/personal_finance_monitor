package com.finance.repository.income;

import com.finance.dao.Income;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Income entities.
 */
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
