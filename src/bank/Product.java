package bank;

import bank.operations.OperationEntry;

import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Product {

    protected List<OperationEntry> operationsHistory;
    protected Bank bank;
    protected int id;


    public Product(Bank bank){
        this.id = Math.toIntExact(Math.round(Math.random() * 100));
        this.bank = bank;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
