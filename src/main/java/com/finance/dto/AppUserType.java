package com.finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Types of application user.
 */
public enum AppUserType {

    @JsonProperty("user")
    USER,

    @JsonProperty("admin")
    ADMIN,
}
