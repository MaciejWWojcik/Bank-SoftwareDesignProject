package bank;

import bank.operations.OperationEntry;

import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Product {

    protected List<OperationEntry> operationsHistory;
    protected Bank bank;
    protected String id;


    public Product(Bank bank){
        this.id = "ID" + Math.random();
        this.bank = bank;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
