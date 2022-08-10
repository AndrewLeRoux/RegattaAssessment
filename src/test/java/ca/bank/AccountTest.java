package ca.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account first = new Account("Andy", "Checking", 10000);
    Account second = new Account("John", "Investment", 600, "Individual");

    @Test
    @DisplayName("Test deposit function")
    void testDeposit() {
        double initialBalance = first.getBalance();
        first.deposit(400);
        assertEquals(initialBalance + 400, first.getBalance(), "Deposit should increase balance by the parameter amount");
    }

    @Test
    @DisplayName("Test withdraw function")
    void testWithdraw() {
        double initialBalance = first.getBalance();
        first.withdraw(400);
        assertEquals(initialBalance - 400, first.getBalance(), "Withdraw should decrease balance by the parameter amount");
    }

    @Test
    @DisplayName("Tests if withdraw function prevents over drafting")
    void testOverdraft() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            second.withdraw(700);
        });
        assertEquals("insufficient funds", exception.getMessage(), "Withdraw should throw a message if the amount withdrawn is more than the current balance");
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            second.withdraw(501);
        });
        assertEquals("Individual accounts have a withdrawal limit of 500 dollars", exception2.getMessage(), "Individual accounts have a withdrawal limit of 500 dollars");
    }

    @Test
    @DisplayName("Tests individual account limit")
    void testIndividualAccount() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            second.withdraw(501);
        });
        assertEquals("Individual accounts have a withdrawal limit of 500 dollars", exception.getMessage(), "Individual accounts have a withdrawal limit of 500 dollars");
    }

    @Test
    void testTransfer() {
        double firstBalance = first.getBalance();
        double secondBalance = second.getBalance();
        first.transfer(second, 400);
        assertAll("Transfer",
                () -> assertEquals(firstBalance - 400, first.getBalance(), "The account being withdrawn from should have it's balance decreased by the transfer amount"),
                () -> assertEquals(secondBalance + 400, second.getBalance(), "The account receiving funds should have it's balance increased by the transfer amount")
        );
    }
}
