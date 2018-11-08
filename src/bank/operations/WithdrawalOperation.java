package bank.operations;

import bank.Account;

import java.util.Date;

public class WithdrawalOperation extends Operation {

    protected String name = "Withdrawal Operation";
    private Account account;
    private double withdrawalValue;

    public WithdrawalOperation(Account account, double withdrawalValue) {
        this.account = account;
        this.withdrawalValue = withdrawalValue;
    }

    @Override
    public OperationEntry execute() {
        boolean result = this.account.charge(withdrawalValue);

        if(result){
            return new OperationEntry(this.name, this.account.getId(), new Date().toString(), "COMPLETED");
        }else {
            return new OperationEntry(this.name, this.account.getId(), new Date().toString(), "FAILED");
        }
    }

}
