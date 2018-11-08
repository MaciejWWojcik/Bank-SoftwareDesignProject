package bank.rates;

import bank.Account;

/**
 * Created by Maciej on 11.10.2018.
 */
public class ChristmasInterestRate implements InterestRate{

    private Account account;

    public ChristmasInterestRate(Account account) {
        this.account = account;
    }

    public double calculate(){
        return this.account.getBalance() % 10 + 5;
    }
}
