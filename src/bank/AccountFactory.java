package bank;

import bank.operations.Operation;

import java.util.List;

public class AccountFactory {

    public static int nextAccountId = 1;

    public Account account;

    public AccountFactory(Bank bank, List<Operation> availableOperations) {
        this.account = new Account(bank, availableOperations);

    }

    public Account build() {
        this.account.setId(nextAccountId++);
        return this.account;
    }

}
