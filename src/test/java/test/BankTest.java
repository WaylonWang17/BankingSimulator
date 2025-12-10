package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BankAccount;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    //createAccount tests
    @Test
    void testCreateAccountAddsAccount() {
        bank.createAccount("Alice", 100);
        BankAccount acc = bank.lookUpAccounts(1);

        assertNotNull(acc);
        assertEquals("Alice", acc.getName());
        assertEquals(100, acc.getBalance());
    }

    @Test
    void testAccountNumberIncrements() {
        bank.createAccount("A", 10);
        bank.createAccount("B", 20);

        assertNotNull(bank.lookUpAccounts(1));
        assertNotNull(bank.lookUpAccounts(2));
        assertNull(bank.lookUpAccounts(3)); //no third account
    }

    //lookUpAccounts tests
    @Test
    void testLookupInvalidAccountReturnsNull() {
        assertNull(bank.lookUpAccounts(999));
    }

    //deposit tests
    @Test
    void testDepositIncreasesBalance() {
        bank.createAccount("Alice", 100);

        bank.deposit(1, 50);

        assertEquals(150, bank.lookUpAccounts(1).getBalance());
    }

    @Test
    void testDepositOnInvalidAccountDoesNothing() {
        assertDoesNotThrow(() -> bank.deposit(999, 50));
    }

    //withdraw tests
    @Test
    void testWithdrawDecreasesBalance() {
        bank.createAccount("Bob", 100);

        bank.withdraw(1, 30);

        assertEquals(70, bank.lookUpAccounts(1).getBalance());
    }

    @Test
    void testWithdrawOnInvalidAccountDoesNothing() {
        assertDoesNotThrow(() -> bank.withdraw(999, 20));
    }

    //transfer tests
    @Test
    void testTransferSuccess() {
        bank.createAccount("A", 200);
        bank.createAccount("B", 100);

        bank.transfer(2, 1, 50);  //move 50 from A → B

        assertEquals(150, bank.lookUpAccounts(1).getBalance()); //A loses 50
        assertEquals(150, bank.lookUpAccounts(2).getBalance()); //B gains 50
    }

    @Test
    void testTransferInsufficientFundsDoesNothing() {
        bank.createAccount("A", 20);
        bank.createAccount("B", 100);

        bank.transfer(2, 1, 50); //A cannot send 50

        assertEquals(20, bank.lookUpAccounts(1).getBalance());
        assertEquals(100, bank.lookUpAccounts(2).getBalance());
    }

    @Test
    void testTransferInvalidAccountDoesNothing() {
        bank.createAccount("A", 100);

        assertDoesNotThrow(() -> bank.transfer(999, 1, 20)); //invalid receiver
        assertDoesNotThrow(() -> bank.transfer(1, 999, 20)); //invalid sender
    }
}
