package bank.reports;

import bank.Account;
import bank.Deposit;
import bank.Loan;

/**
 * Created by Maciej on 11.10.2018.
 */
public interface IReportGenerateable {

    void visit(Loan credit);

    void visit(Account account);

    void visit(Deposit deposit);

    void generate();
}
