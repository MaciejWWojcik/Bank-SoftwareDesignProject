package bank;

import bank.operations.Operation;
import bank.rates.InitialInterestRate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Deposit extends Account {

    private Date expirationDate;
    protected Account ownerAccount;

    public Deposit(Bank bank, List<Operation> availableOperations, double balance, Date expirationDate) {
        super(bank, availableOperations);
        this.expirationDate = expirationDate;
        this.balance = balance;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = this::checkIfExpired;
        executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.SECONDS);
        this.rate = new InitialInterestRate(this);
    }

    public void registerAccount(Account account) {
        this.ownerAccount = account;
    }

    protected void checkIfExpired() {
        Date currentDate = Calendar.getInstance().getTime();
        if (currentDate.after(expirationDate)) {
            notifyAboutExpiration();
        }
    }

    public Account getOwnerAccount() {
        return ownerAccount;
    }

    private void notifyAboutExpiration() {
        this.ownerAccount.depositExpired(this);
    }

    public double withdrawAfterExpiration() {
        return this.balance * this.rate.calculate();
    }
}
