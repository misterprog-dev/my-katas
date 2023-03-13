package com.dsoumaila.tdd_double_loop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;

public class Transaction {

    private final BigDecimal amount;
    private final LocalDate date;

    public Transaction(BigDecimal amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public String print(BigDecimal balance) {
        if (ZERO.compareTo(amount) > 0){
            return formatDateTransaction(date) + " | | " + scaleAmount(amount.abs()) + " | " + scaleAmount(balance);
        }
        return formatDateTransaction(date) + " | " + scaleAmount(amount) + " | | " + scaleAmount(balance);
    }

    private BigDecimal scaleAmount(BigDecimal value) {
        return value.setScale(2, HALF_UP);
    }

    private String formatDateTransaction(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return  false;

        Transaction t = (Transaction) o;
        return t.amount.equals(amount) && t.date.equals(date);
    }

    @Override
    public int hashCode() {
        return 31 * amount.hashCode() + date.hashCode() ;
    }
}
