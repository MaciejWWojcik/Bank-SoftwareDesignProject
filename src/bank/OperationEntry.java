package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class OperationEntry {

    private String type;
    private String relatedProductId;
    private String executionDate;
    private String description;


    public OperationEntry(String type, String relatedProductId, String executionDate, String description) {
        this.type = type;
        this.relatedProductId = relatedProductId;
        this.executionDate = executionDate;
        this.description = description;
    }
}
