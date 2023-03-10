package com.finance.dto;

import com.finance.dao.AppUser;
import com.finance.dao.AppUserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object of the app user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    private AppUserType appUserRole;

    private Boolean locked;

    private Boolean enabled;

    /**
     * Fluent style API fashion appUserDto builder.
     */
    public AppUserDto withId(Long id){
        this.id = id;
        return this;
    }

    public AppUserDto withUsername(String username){
        this.username = username;
        return this;
    }

    public AppUserDto withEmail(String email){
        this.email = email;
        return this;
    }

    public AppUserDto withPassword(String password){
        this.password = password;
        return this;
    }

    public AppUserDto withAppUserRole(AppUserType appUserRole){
        this.appUserRole = appUserRole;
        return this;
    }

    public AppUserDto isLocked(Boolean locked){
        this.locked = locked;
        return this;
    }

    public AppUserDto isEnabled(Boolean enabled){
        this.enabled = enabled;
        return this;
    }

}
