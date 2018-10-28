package bank;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountTest {

    Bank bank;
    Account account;

    @BeforeAll
    public void init(){
        this.bank = new Bank(0);
    }

    @BeforeEach
    public void initAccount(){
        this.account = new Account(this.bank, new ArrayList<>());
    }

    @Test
    public void shouldCreateAccountAndFilledWithAccountInfo() {
        Account account = new Account(this.bank, new ArrayList<>());
        AccountInfo info = new AccountInfo();

        Date today = new Date();
        info.owner = "AccountTester";
        info.openningDate = today.toString();
        info.id = "testID";
        account.assignAccountInfo(info);

        Assertions.assertEquals(account.info.owner, "AccountTester" );
        Assertions.assertEquals(account.info.id, "testID" );
        Assertions.assertNotNull(account.info.openningDate);
    }

    @Test
    public void shouldChargeMoneyIfThereAreSufficientFounds(){
        Account account = this.account;
        account.balance = 1000;
        boolean result = account.charge(500);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotChargeMoneyIfThereAreNotSufficientFounds(){
        Account account = this.account;
        account.balance = 200;
        boolean result = account.charge(500);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldChargeCorrectAmmountFromBalance(){
        Account account = this.account;
        account.balance = 1000;
        account.charge(500);
        Assertions.assertEquals(500, account.balance);
    }

    @Test
    public void shouldDepositMoney(){
        Account account = this.account;
        account.balance = 1000;
        boolean result = account.deposit(500);
        Assertions.assertTrue(result);
    }

    @Test
    public void balanceAfterDepositShouldBeCorrect(){
        Account account = this.account;
        account.balance = 1000;
        boolean result = account.deposit(500);
        Assertions.assertEquals(1500, account.balance);
    }

    @Test
    public void shouldBeAbleToCreateDepositIfThereAreSufficientFounds(){
        Account account = this.account;
        account.balance = 1000;
        Date today = new Date();
        boolean result = account.createDeposit(500, today);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotBeAbleToCreateDepositIfThereAreNotSufficientFounds(){
        Account account = this.account;
        account.balance = 400;
        Date today = new Date();
        boolean result = account.createDeposit(500, today);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldBeAbleToCreateLoan(){
        Account account = this.account;
        boolean result = account.createLoan(500, 100);
        Assertions.assertTrue(result);
    }

    @Test
    public void balanceAfterLoanShouldBeBigger(){
        Account account = this.account;
        account.balance = 100;
        double balance = account.balance;
        account.createLoan(500, 100);
        Assertions.assertTrue(balance < account.balance);
    }

    @Test
    public void balanceAfterDepositShouldBeSmaller(){
        Account account = this.account;
        account.balance = 500;
        double balance = account.balance;
        Date today = new Date();
        account.createDeposit(100, today);
        Assertions.assertTrue(balance > account.balance);
    }
}
