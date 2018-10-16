package bank;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Loan extends Account {

    private double loanValue;
    private double installment;
    private Account ownerAccount;

    public Loan(Bank bank, List<Operation> availableOperations, double loanValue, double installment) {
        super(bank, availableOperations);
        this.installment = installment;
        this.loanValue = loanValue;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = this::withdraw;
        executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.MINUTES);
    }

    private void withdraw() {
        ownerAccount.charge(installment);
        loanValue -= installment;
        checkIfExpired();
    }

    public void registerAccount(Account account) {
        this.ownerAccount = account;
    }

    private void checkIfExpired() {
        if(loanValue == 0) {
            notifyAboutExpiration();
        }
    }

    private void notifyAboutExpiration() {
        ownerAccount.loanFinished(this);
    }
}
