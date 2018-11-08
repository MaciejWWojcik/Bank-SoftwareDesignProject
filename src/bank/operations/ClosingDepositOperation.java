package bank.operations;

import bank.Account;
import bank.Deposit;

import java.util.Date;

public class ClosingDepositOperation extends Operation {

    protected String name = "Close deposit Operation";
    private Deposit deposit;

    public ClosingDepositOperation(Deposit deposit) {
        this.deposit = deposit;
    }

    @Override
    public OperationEntry execute() {
      double money = this.deposit.withdrawAfterExpiration();
      boolean result = this.deposit.getOwnerAccount().deposit(money);

        if(result){
            return new OperationEntry(this.name, this.deposit.getId(), new Date().toString(), "COMPLETED");
        }else {
            return new OperationEntry(this.name, this.deposit.getId(), new Date().toString(), "FAILED");
        }

    }

}
