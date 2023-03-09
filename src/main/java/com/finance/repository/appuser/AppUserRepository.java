package com.finance.repository.income;

import com.finance.dao.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for AppUser entities.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
