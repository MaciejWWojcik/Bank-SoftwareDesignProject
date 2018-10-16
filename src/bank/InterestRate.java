package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class InterestRate {

    private Account account;

    public InterestRate(Account account) {
        this.account = account;
    }

    public double calculate(){
        return Math.floor(Math.random() * 5);
    }
}
