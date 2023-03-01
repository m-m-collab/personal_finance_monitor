package com.finance.repository;

import com.finance.dto.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository for Income entities.
 */
public interface IncomeRepository extends JpaRepository<Income, Long> {

    void deleteIncomeById(Long id);

    Optional<Income> findIncomeById(Long id);

    //TODO: add more. For example find by income category.
}
