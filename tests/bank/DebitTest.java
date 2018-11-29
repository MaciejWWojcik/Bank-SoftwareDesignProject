package bank;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DebitTest {

    private Bank bank;
    private Debit debit;

    @BeforeAll
    public void init() {
        bank = new Bank(1);
        Account account = new Account(bank, new ArrayList<>());
        debit = new Debit(bank, 20, account);
    }

    @BeforeEach
    public void resetAccountState() {
        debit.resetState();
    }

    @Test
    public void shouldFailOnTryingCharge() {
        boolean result = debit.charge(25);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldIncreaseDebitOnAccount() {
        boolean result = debit.charge(15);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, debit.getAccountBalance());
        Assertions.assertEquals(15, debit.currentValue);
    }

    @Test
    public void shouldDecreaseDebitAfterDeposit() {
        debit.currentValue = 15;
        boolean result = debit.deposit(20);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, debit.currentValue);
        Assertions.assertEquals(5, debit.getAccountBalance());
    }

    @Test
    public void shouldIncreaseBalanceAfterDeposit() {
        boolean result = debit.deposit(20);
        Assertions.assertTrue(result);
        Assertions.assertEquals(20, debit.getAccountBalance());
    }
}
