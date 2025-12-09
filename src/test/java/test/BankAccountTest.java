package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.BankAccount;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount b = new BankAccount("Walton", 1840608, 100);

        b.deposit(30);

        assertEquals(130, b.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount b = new BankAccount("Walton", 1840608, 100);

        b.withdraw(50);

        assertEquals(50, b.getBalance());
    }

    @Test
    public void testInsufficientFunds() {
        BankAccount b = new BankAccount("Walton", 1840608, 100);

        b.withdraw(200);

        assertEquals(100, b.getBalance());
    }
}
