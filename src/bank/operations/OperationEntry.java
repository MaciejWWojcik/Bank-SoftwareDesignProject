package bank.operations;

/**
 * Created by Maciej on 11.10.2018.
 */
public class OperationEntry {

    private String type;
    private int relatedProductId;
    private String executionDate;
    private String description;


    public OperationEntry(String type, int relatedProductId, String executionDate, String description) {
        this.type = type;
        this.relatedProductId = relatedProductId;
        this.executionDate = executionDate;
        this.description = description;
    }
}
