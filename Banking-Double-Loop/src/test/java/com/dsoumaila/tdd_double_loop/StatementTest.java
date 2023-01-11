package com.dsoumaila.tdd_double_loop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StatementTest {
    @Test
    public void should_print_only_header_when_empty() {
        // GIVEN
        Statement statement = new Statement();

        // WHEN
        String printedStatement = statement.print();

        // THEN
        assertThat(printedStatement).isEqualTo("date | credit | debit | balance");
    }

    @Test
    public void should_print_statement_with_one_transaction() {
        // GIVEN
        Transaction transaction = mock(Transaction.class);
        when(transaction.getAmount()).thenReturn(new BigDecimal("1000"));
        when(transaction.print(new BigDecimal("1000"))).thenReturn("10/01/2012 | 1000.00 | | 1000.00");

        Statement statement = new Statement();
        statement.add(transaction);

        // WHEN
        String printedStatement = statement.print();

        // THEN
        assertThat(printedStatement).isEqualTo(
                "date | credit | debit | balance\n" +
                        "10/01/2012 | 1000.00 | | 1000.00"
        );
    }
}
