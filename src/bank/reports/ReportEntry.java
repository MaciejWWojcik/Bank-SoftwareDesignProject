package bank.reports;

public class ReportEntry {

    private String productId;
    private String name;
    private double balance;

    public ReportEntry(String productId, String name, double balance) {
        this.productId = productId;
        this.name = name;
        this.balance = balance;
    }
}
