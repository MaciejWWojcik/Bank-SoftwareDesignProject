package bank;

import bank.operations.Operation;
import bank.rates.InterestRate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Account extends Product {

    protected double balance;
    protected List<Deposit> deposits;
    protected List<Loan> loans;
    protected AccountInfo info;
    protected InterestRate rate;
    protected List<Operation> availableOperations;

    public Account(Bank bank, List<Operation> availableOperations) {
        super(bank);
        this.availableOperations = availableOperations;
        this.deposits = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void assignAccountInfo(AccountInfo info) {
        if (this.info == null) {
            this.info = info;
        }
    }

    public boolean createDeposit(double moneyForDeposit, Date expirationDate) {
        if (this.charge(moneyForDeposit)) {
            Deposit deposit = new Deposit(this.bank, new ArrayList<>(), moneyForDeposit, expirationDate);
            deposit.registerAccount(this);
            deposits.add(deposit);
            return true;
        }
        return false;
    }

    public boolean createLoan(double loanValue, double installment) {
        if (this.deposit(loanValue)) {
            Loan loan = new Loan(this.bank, new ArrayList<>(), loanValue, installment);
            loan.registerAccount(this);
            loans.add(loan);
            return true;
        }
        return false;
    }

    public void depositExpired(Deposit deposit) {
        double moneyFromDeposit = deposit.withdrawAfterExpiration();
        balance += moneyFromDeposit;
        deposits.remove(deposit);
    }

    public void loanFinished(Loan loan) {
        loans.remove(loan);
    }

    public boolean charge(double chargeValue) {
        if (balance - chargeValue > 0) {
            balance -= chargeValue;
            return true;
        }
        return false;
    }

    public void chargeAll() {
        this.balance = 0;
    }

    public boolean deposit(double depositValue) {
        this.balance += depositValue;
        return true;
    }

    public double getBalance() {
        return balance;
    }


}
