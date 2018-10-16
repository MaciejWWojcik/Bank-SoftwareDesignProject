package bank;

import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Bank {

    private int id;
    private String name;
    private List<Product> products;
    private List<OperationEntry> operationsHistory;
    private List<Transfer> transfers;


    public Bank(int id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.operationsHistory = new ArrayList<>();
        this.transfers = new ArrayList<>();
    }

    public void addOperation(OperationEntry operation) {
        this.operationsHistory.add(operation);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Transfer> gatherTransfers() {
        List<Transfer> gatheredTransfers = new ArrayList<>(this.transfers);
        this.transfers.clear();
        return gatheredTransfers;
    }

    public void receiveTransfer(Transfer incomingTransfer) {

    }

    public int getId() {
        return id;
    }
}
