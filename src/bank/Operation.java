package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public abstract class Operation {


    private String name;
    private String definition; //TODO how the definition should be stored? Maybe overriding the execute() will be sufficient;


    //TODO should Operation operates on the account itself or should it return value (positive or negative) to add to the account balance
    public abstract OperationEntry execute();
}
