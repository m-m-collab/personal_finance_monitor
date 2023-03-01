package com.finance.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity model of the income table.
 */
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Income income;

    private Double incomeValue;

    public Income(){};

    public Income(Long id, LocalDateTime dateTime, Income income, Double incomeValue) {
        this.id = id;
        this.dateTime = dateTime;
        this.income = income;
        this.incomeValue = incomeValue;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Income getIncome() {
        return income;
    }

    public Double getIncomeValue() {
        return incomeValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public void setIncomeValue(Double incomeValue) {
        this.incomeValue = incomeValue;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", income=" + income +
                ", incomeValue=" + incomeValue +
                '}';
    }
}
