package bank;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class DebitAccount extends Account {

    private double debitLevel;
    private double debit;


    public DebitAccount(Bank bank, List<Operation> availableOperations) {
        super(bank, availableOperations);
    }

    public void setDebitLevel(double debitLevel) {
        this.debitLevel = debitLevel;
    }

    @Override
    public boolean charge(double chargeValue) {
        // TODO handle charging
        return false;
    }

    @Override
    public boolean deposit(double depositValue) {
        // TODO handle depositing
        return false;
    }

    @Override
    public double getBalance() {
        // TODO balance - debit
        return  -1;
    }
}
