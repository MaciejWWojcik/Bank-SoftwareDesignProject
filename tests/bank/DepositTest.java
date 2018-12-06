package bank;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DepositTest {


    Account owner;
    Deposit deposit;

    @BeforeAll
    public void init(){
    }

    @BeforeEach
    public void initAccount(){
        Bank bank = new Bank(1);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        owner = new Account(bank,new ArrayList<>());
        deposit = new Deposit(bank, new ArrayList<>(), 1000, calendar.getTime());
        deposit.registerAccount(owner);
    }

    @Test
    public void shouldTheDepositBeRegisteredCorrectly() {
        Assertions.assertNotNull(deposit.ownerAccount);
    }

    @Test
    public void accountBalanceShouldIncreaseAfterExpiration() throws InterruptedException {
        deposit.checkIfExpired();
        Assertions.assertTrue(owner.balance > 0);
    }

}
