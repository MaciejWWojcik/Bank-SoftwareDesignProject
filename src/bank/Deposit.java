package bank;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Deposit extends Account {


    private String expirationDate;
    private Account ownerAccount;

    public Deposit(Bank bank, List<Operation> availableOperations) {
        super(bank, availableOperations);

        // TODO invoke checkIfExpired periodicaly
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
