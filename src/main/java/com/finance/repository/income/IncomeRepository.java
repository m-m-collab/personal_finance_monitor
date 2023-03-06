package com.finance.repository.income;

import com.finance.dao.Income;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Repository for Income entities.
 */
public interface IncomeRepository extends ReactiveCrudRepository<Income, Long> {

}
