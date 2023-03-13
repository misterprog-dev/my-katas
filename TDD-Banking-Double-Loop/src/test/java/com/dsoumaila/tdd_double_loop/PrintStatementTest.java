package com.dsoumaila.tdd_double_loop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.time.LocalDate.of;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintStatementTest {
    @Test
    public void should_print_statement() {
        // GIVEN
        Account account = new Account(new Statement());
        account.deposit(new BigDecimal("1000"), of(2012, JANUARY, 10));
        account.deposit(new BigDecimal("2000"), of(2012, JANUARY, 13));
        account.withdraw(new BigDecimal("500"), of(2012, JANUARY, 14));

        // WHEN
        String statement = account.printStatement();

        // THEN
        assertEquals(statement,
                "date | credit | debit | balance\n" +
                "14/01/2012 | | 500.00 | 2500.00\n" +
                "13/01/2012 | 2000.00 | | 3000.00\n" +
                "10/01/2012 | 1000.00 | | 1000.00"
        );
    }
}
