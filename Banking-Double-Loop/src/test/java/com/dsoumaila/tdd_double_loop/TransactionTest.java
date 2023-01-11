package com.dsoumaila.tdd_double_loop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.time.LocalDate.of;
import static java.time.Month.JANUARY;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {
    @Test
    public void should_print_deposit() {
        // GIVEN
        Transaction transaction = new Transaction(new BigDecimal("1000"), of(2012, JANUARY, 10));

        // WHEN
        String printedDeposite = transaction.print(new BigDecimal("1000"));

        // THEN
        assertThat(printedDeposite).isEqualTo("10/01/2012 | 1000.00 | | 1000.00");
    }

    @Test
    public void should_print_withdraw() {
        // GIVEN
        Transaction transaction = new Transaction(new BigDecimal("-1000"), of(2012, JANUARY, 10));

        // WHEN
        String printedDeposite = transaction.print(new BigDecimal("1000"));

        // THEN
        assertThat(printedDeposite).isEqualTo("10/01/2012 | | 1000.00 | 1000.00");
    }
}
