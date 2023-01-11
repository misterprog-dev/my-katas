package com.dsoumaila.tdd_double_loop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.time.LocalDate.of;
import static java.time.Month.OCTOBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AccountTest {
    @Test
    public void should_print_statement() {
        // GIVEN
        Statement statement = mock(Statement.class);
        when(statement.print()).thenReturn("Printed Statement");
        Account account = new Account(statement);

        // WHEN
        String printedStatement = account.printStatement();

        // THEN
        assertThat(printedStatement).isEqualTo("Printed Statement");
    }

    @Test
    public void should_deposit_amount() {
        // GIVEN
        Statement statement = mock(Statement.class);
        Account account = new Account(statement);

        // WHEN
        account.deposit(new BigDecimal("100"), of(2022, OCTOBER, 22));

        // THEN
        verify(statement).add(new Transaction(new BigDecimal("100"), of(2022, OCTOBER, 22)));
    }

    @Test
    public void should_withdraw_amount() {
        // GIVEN
        Statement statement = mock(Statement.class);
        Account account = new Account(statement);

        // WHEN
        account.withdraw(new BigDecimal("100"), of(2022, OCTOBER, 22));

        // THEN
        verify(statement).add(new Transaction(new BigDecimal("100").negate(), of(2022, OCTOBER, 22)));
    }

}
