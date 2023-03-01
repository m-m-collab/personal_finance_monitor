package com.finance.dto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity model of the income table.
 */
@Entity
@Table(name = "Income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private AppUser appUser;

    @Column(name = "DateTime", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Income income;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    public Income(){};

    public Income(Long id, LocalDateTime dateTime, Income income, BigDecimal amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.income = income;
        this.amount = amount;
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

    public BigDecimal getIncomeValue() {
        return amount;
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

    public void setAmountValue(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", income=" + income +
                ", amount=" + amount +
                '}';
    }
}
