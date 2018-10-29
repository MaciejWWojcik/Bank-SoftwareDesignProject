package bank;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DebitAccountTest {

    Bank bank;
    DebitAccount account;

    @BeforeAll
    public void init() {
        bank = new Bank(1);
        account = new DebitAccount(bank, new ArrayList<>());
        account.setDebitLevel(20);
    }

    @BeforeEach
    public void resetAccountState() {
        account.balance = 0.0;
        account.debit = 0.0;
    }

    @Test
    public void shouldFailOnTryingCharge() {
        boolean result = account.charge(25);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldIncreaseDebitOnAccount() {
        boolean result = account.charge(15);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, account.balance);
        Assertions.assertEquals(15, account.debit);
    }

    @Test
    public void shouldDecreaseDebitAfterDeposit() {
        account.debit = 15;
        boolean result = account.deposit(20);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, account.debit);
        Assertions.assertEquals(5, account.balance);
    }

    @Test
    public void shouldIncreaseBalanceAfterDeposit() {
        boolean result = account.deposit(20);
        Assertions.assertTrue(result);
        Assertions.assertEquals(20, account.balance);
    }
}
