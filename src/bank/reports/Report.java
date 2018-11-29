package bank.reports;

import bank.Account;
import bank.Deposit;
import bank.Loan;
import bank.Product;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public abstract class Report implements IReportGenerateable {

    protected List<Product> products;
    protected List<ReportEntry> reportEntries;

    public Report(List<Product> products) {
        this.products = products;
    }

    @Override
    public void generate() {
        this.products.stream()
                .filter(product -> product instanceof Loan)
                .map(product -> (Loan) product)
                .forEach(this::visit);
        this.products.stream()
                .filter(product -> product instanceof Deposit)
                .map(product -> (Deposit) product)
                .forEach(this::visit);
        this.products.stream()
                .filter(product -> !(product instanceof Loan) && !(product instanceof Deposit))
                .map(product -> (Account) product)
                .forEach(this::visit);
    }
}
