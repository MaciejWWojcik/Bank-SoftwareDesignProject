package bank.reports;

import bank.Account;
import bank.Deposit;
import bank.Loan;
import bank.Product;

import java.util.List;

public class Report1000 extends Report {


    public Report1000(List<Product> products) {
        super(products);
    }

    @Override
    public void visit(Loan credit) {
        this.reportEntries.add(new ReportEntry(credit.getId(),"Loan", credit.getBalance()));
    }

    @Override
    public void visit(Account account) {
        this.reportEntries.add(new ReportEntry(account.getId(),"Account", account.getBalance()));
    }

    @Override
    public void visit(Deposit deposit) {
        this.reportEntries.add(new ReportEntry(deposit.getId(),"Deposit", deposit.getBalance()));
    }
}
