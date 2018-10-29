package bank;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class DebitAccount extends Account {

    private double debitLevel;
    protected double debit;


    public DebitAccount(Bank bank, List<Operation> availableOperations) {
        super(bank, availableOperations);
    }

    public void setDebitLevel(double debitLevel) {
        this.debitLevel = debitLevel;
    }

    @Override
    public boolean charge(double chargeValue) {
        if(this.balance - chargeValue < 0) {
            if(Math.abs(this.balance - chargeValue) > debitLevel) {
                return false;
            }
            this.balance -= chargeValue;
            if(this.balance < 0) {
                double debitIncrease = Math.abs(this.balance);
                debit += debitIncrease;
                this.balance = 0;
            }
            return true;
        } else if (debit + chargeValue > debitLevel) {
            return false;
        } else {
            this.balance -= chargeValue;
            return true;
        }
    }

    @Override
    public boolean deposit(double depositValue) {
        if(debit > 0) {
            debit -= depositValue;
            if(this.debit < 0) {
                double accountIncome = Math.abs(this.debit);
                this.balance += accountIncome;
                this.debit = 0;
            }
        } else {
            balance += depositValue;
        }
        return true;
    }

    @Override
    public double getBalance() {
        return this.balance - this.debit;
    }
}
