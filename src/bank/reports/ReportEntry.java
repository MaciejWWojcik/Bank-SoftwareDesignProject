package bank.reports;

public class ReportEntry {

    private int productId;
    private String name;
    private double balance;

    public ReportEntry(int productId, String name, double balance) {
        this.productId = productId;
        this.name = name;
        this.balance = balance;
    }
}
