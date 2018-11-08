package bank.rates;

import bank.Account;

/**
 * Created by Maciej on 11.10.2018.
 */
public class InitialInterestRate implements InterestRate{

    private Account account;

    public InitialInterestRate(Account account) {
        this.account = account;
    }

    public double calculate(){
        return Math.floor(Math.random() * 5);
    }
}
