package com.finance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity model of the income table.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    /**
     * Fluent style API fashion income builder.
     */
    public static class IncomeBuilder {
        private AppUser appUser;
        private LocalDateTime dateTime;
        private Income income;
        private BigDecimal amount;

        public IncomeBuilder withAppUser(AppUser appUser){
            this.appUser = appUser;
            return this;
        }

        public IncomeBuilder withDateTime(LocalDateTime dateTime){
            this.dateTime = dateTime;
            return  this;
        }

        public IncomeBuilder withIncome(Income income){
            this.income = income;
            return this;
        }

        public IncomeBuilder withAmount(BigDecimal amount){
            this.amount = amount;
            return this;
        }

        public Income build(){
            return new Income(this);
        }
    }

    private Income(IncomeBuilder incomeBuilder){
        this.appUser = incomeBuilder.appUser;
        this.dateTime = incomeBuilder.dateTime;
        this.income = incomeBuilder.income;
        this.amount = incomeBuilder.amount;
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
