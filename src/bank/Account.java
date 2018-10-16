package bank;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Account extends Product{

    protected double balance;
    protected List<Deposit> deposits;
    protected List<Loan> loans;
    protected AccountInfo info;
    protected InterestRate rate;
    protected List<Operation> availableOperations;

    public Account(Bank bank, List<Operation> availableOperations){
        super(bank);
        this.availableOperations = availableOperations;
    }

    public void depositExpired(Deposit deposit){
        double moneyFromDeposit = deposit.withdrawAfterExpiration();
        balance += moneyFromDeposit;
        deposits.remove(deposit);
    }

    public boolean charge(double chargeValue){
        // TODO handle charging
        return false;
    }

    public boolean deposit(double depositValue){
        // TODO handle depositing
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
