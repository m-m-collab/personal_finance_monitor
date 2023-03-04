package com.finance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity model of the expense table.
 */
@Entity
@Table(name = "Expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
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
    private ExpenseType expensetype;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", expense=" + expensetype +
                ", amount=" + amount +
                '}';
    }

}
