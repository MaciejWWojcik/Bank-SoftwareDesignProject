package bank;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
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
        Date today = new Date();
        owner = new Account(bank,new ArrayList<>());
        deposit = new Deposit(bank, new ArrayList<>(), 1000, today);
        deposit.registerAccount(owner);
    }

    @Test
    public void shouldTheDepositBeRegisteredCorrectly() {
        Assertions.assertNotNull(deposit.ownerAccount);
    }

    @Test
    public void accountBalanceShouldIncreaseAfterExpiration(){
        Assertions.assertTrue(owner.balance > 0);
    }

}
