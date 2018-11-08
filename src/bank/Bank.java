package bank;

import bank.operations.OperationEntry;

import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Bank {

    private int id;
    private String name;
    protected List<Product> products;
    protected List<OperationEntry> operationsHistory;
    protected List<Transfer> transfers;
    protected List<Transfer> receivedTransfers;


    public Bank(int id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.operationsHistory = new ArrayList<>();
        this.transfers = new ArrayList<>();
        this.receivedTransfers = new ArrayList<>();
    }

    protected void addTransfer(Transfer transfer) {
        transfers.add(transfer);
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
        this.receivedTransfers.add(incomingTransfer);
    }

    public int getId() {
        return id;
    }
}
