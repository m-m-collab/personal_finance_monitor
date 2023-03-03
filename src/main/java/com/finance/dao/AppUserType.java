package com.finance.dao;

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
