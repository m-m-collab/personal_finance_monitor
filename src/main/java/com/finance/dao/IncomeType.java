package com.finance.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Types of financial income.
 */
public enum IncomeType {

    @JsonProperty("salary")
    SALARY,

    @JsonProperty("other")
    OTHER,

    //TODO: add more types.

}
