package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Debit extends Product {

    private double debitLevel;
    protected double currentValue;
    private Account account;


    public Debit(Bank bank, double debitLevel, Account account) {
        super(bank);
        this.debitLevel = debitLevel;
        this.account = account;
        this.currentValue = 0;
    }

    public void setDebitLevel(double debitLevel) {
        this.debitLevel = debitLevel;
    }

    public boolean charge(double chargeValue) {
        if(this.account.getBalance() == 0) {
            if(chargeValue > this.debitLevel - this.currentValue) {
                return false;
            }
            this.currentValue += chargeValue;
            return true;
        } else if (this.account.getBalance() - chargeValue < 0) {
            if (Math.abs(this.account.getBalance() - chargeValue) > debitLevel) {
                return false;
            }
            this.account.charge(chargeValue);
            if (this.getDebitBalance() < 0) {
                double debitIncrease = Math.abs(this.getDebitBalance());
                currentValue += debitIncrease;
                this.account.chargeAll();
            }
            return true;
        } else if (currentValue + chargeValue > debitLevel) {
            return false;
        } else {
            this.account.charge(chargeValue);
            return true;
        }
    }

    public boolean deposit(double depositValue) {
        if (currentValue > 0) {
            currentValue -= depositValue;
            if (this.currentValue < 0) {
                double accountIncome = Math.abs(this.currentValue);
                this.account.deposit(accountIncome);
                this.currentValue = 0;
            }
        } else {
            this.account.deposit(depositValue);
        }
        return true;
    }

    public double getDebitBalance() {
        return this.account.getBalance() - this.currentValue;
    }

    public double getAccountBalance() {
        return this.account.getBalance();
    }

    public void resetState() {
        this.currentValue = 0.0;
        this.account.chargeAll();
    }
}
