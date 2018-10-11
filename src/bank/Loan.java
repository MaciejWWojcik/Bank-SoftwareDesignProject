package bank;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Loan extends Account{

    private double loanValue;
    private Account ownerAccount;

    public Loan(Bank bank, List<Operation> availableOperations) {
        super(bank, availableOperations);

        // TODO invoke withdraw periodicaly
    }

    private void withdraw(){
        // TODO withdraw from account
        // TODO check if fullfilled
    }

    public void registerAccount(Account account){
        // TODO assign to ownerAccount
    }

    private void checkIfExpired(){
        // TODO invoke notifyParentAboutExpiration
    }

    private void notifyAboutExpiration(){
        // TODO notify owner
    }
}
