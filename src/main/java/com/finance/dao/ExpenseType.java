package com.finance.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Types of expenses.
 */
public enum ExpenseType {

    @JsonProperty("food")
    FOOD,

    @JsonProperty("home")
    HOME,

    @JsonProperty("bills")
    BILLS,

    @JsonProperty("health")
    HEALTH,

    @JsonProperty("clothes")
    CLOTHES,

    @JsonProperty("hobbies")
    HOBBIES,

    @JsonProperty("transport")
    TRANSPORT,

    @JsonProperty("other")
    OTHER

    //TODO: add more types.
}
