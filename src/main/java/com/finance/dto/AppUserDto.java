package com.finance.dto;

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
}
