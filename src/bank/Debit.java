package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Debit extends Product {

    private double debitLevel;
    protected double debit;
    private Account account;


    public Debit(Bank bank, double debitLevel, Account account) {
        super(bank);
        this.debitLevel = debitLevel;
        this.account = account;
        this.debit = 0;
    }

    public void setDebitLevel(double debitLevel) {
        this.debitLevel = debitLevel;
    }

    public boolean charge(double chargeValue) {
        if(this.account.getBalance() - chargeValue < 0) {
            if(Math.abs(this.account.getBalance() - chargeValue) > debitLevel) {
                return false;
            }
            this.account.charge(chargeValue);
            if(this.getBalance() < 0) {
                double debitIncrease = Math.abs(this.getBalance());
                debit += debitIncrease;
                this.account.chargeAll();
            }
            return true;
        } else if (debit + chargeValue > debitLevel) {
            return false;
        } else {
            this.charge(chargeValue);
            return true;
        }
    }

    public boolean deposit(double depositValue) {
        if(debit > 0) {
            debit -= depositValue;
            if(this.debit < 0) {
                double accountIncome = Math.abs(this.debit);
                this.account.deposit(accountIncome);
                this.debit = 0;
            }
        } else {
            this.account.deposit(depositValue);
        }
        return true;
    }

    public double getBalance() {
        return this.account.getBalance() - this.debit;
    }
}
