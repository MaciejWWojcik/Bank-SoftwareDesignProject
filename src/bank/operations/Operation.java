package bank.operations;

/**
 * Created by Maciej on 11.10.2018.
 */
public abstract class Operation {

    protected String name;


    //TODO should Operation operates on the account itself or should it return value (positive or negative) to add to the account balance
    public abstract OperationEntry execute();
}
