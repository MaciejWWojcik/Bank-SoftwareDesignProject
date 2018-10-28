package bank;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoanTest {


    Account owner;
    Loan loan;
    Bank bank;

    @BeforeAll
    public void init(){
    }

    @BeforeEach
    public void initAccount(){
        bank = new Bank(1);
        owner = new Account(bank,new ArrayList<>());
        loan = new Loan(bank, new ArrayList<>(), 1000, 100);
        loan.registerAccount(owner);
    }

    @Test
    public void shouldWithdrawFromLoanIfSufficientFounds(){
        owner.balance = 1000;
        boolean result = loan.withdraw();
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotBeAbleToWithdrawFromLoanIfInSufficientFounds(){
        owner.balance = 10;
        boolean result = loan.withdraw();
        Assertions.assertTrue(!result);
    }

    @Test
    public void loanSouldBeRemovedFromOwnerIfExpired(){
        loan = new Loan(bank, new ArrayList<>(), 1000, 1000);
        owner.balance = 1000000;
        loan.registerAccount(owner);
        loan.withdraw();
        Assertions.assertTrue(owner.loans.size() == 0 );
    }

}
