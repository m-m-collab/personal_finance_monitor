package com.finance.observer.income;

import com.finance.dto.IncomeDto;
import java.util.concurrent.Flow;

/**
 * Income publisher.
 */
public interface IncomePublisher {
    public void subscribe(Flow.Subscriber<? super IncomeDto> subscriber);
}
