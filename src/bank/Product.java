package bank;

import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Product {

    protected List<OperationEntry> operationsHistory;
    protected Bank bank;


    public Product(Bank bank){
        this.bank = bank;
    }


}
