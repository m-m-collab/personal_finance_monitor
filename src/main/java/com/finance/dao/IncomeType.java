package com.finance.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Types of financial income.
 */
public enum IncomeType {

    @Schema(description = "Salary")
    SALARY,

    @Schema(description = "Other")
    OTHER,

    //TODO: add more types.

}
