package com.finance.service.appuser.mapper;

import com.finance.dao.AppUser;
import com.finance.dto.AppUserDto;

/**
 * App user mapper DTO<->DAO service.
 */
public class AppUserMapperImp implements AppUserMapper{
    @Override
    public AppUserDto toDto(AppUser appUser) {
        return new AppUserDto()
                .withId(appUser.getId())
                .withUsername(appUser.getUsername())
                .withEmail(appUser.getEmail())
                .withPassword(appUser.getPassword())
                .withAppUserRole(appUser.getAppUserRole())
                .isLocked(appUser.getLocked())
                .isEnabled(appUser.getEnabled());
    }

    @Override
    public AppUser toDao(AppUserDto appUserDto) {
        return new AppUser()
                .withId(appUserDto.getId())
                .withUsername(appUserDto.getUsername())
                .withEmail(appUserDto.getEmail())
                .withPassword(appUserDto.getPassword())
                .withAppUserRole(appUserDto.getAppUserRole())
                .isLocked(appUserDto.getLocked())
                .isEnabled(appUserDto.getEnabled());

    }
}
