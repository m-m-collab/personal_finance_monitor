package com.finance.observer.income;

/**
 * Income subscriber.
 */
@FunctionalInterface
public interface IncomeSubscriber {
    public void onUpdateExpense(Long id);
}
