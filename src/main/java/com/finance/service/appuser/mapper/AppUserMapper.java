package com.finance.service.appuser.mapper;

import com.finance.dao.AppUser;
import com.finance.dto.AppUserDto;

/**
 * App User mapper DTO<->DAO service interface.
 */
public interface AppUserMapper {
    AppUserDto toDto(AppUser appUser);

    AppUser toDao(AppUserDto appUserDto);
}
