package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Transfer {
    private int senderBankId;
    private int receiverBankId;

    public Transfer(int senderBankId, int receiverBankId) {
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
    }

    public int getReceiverBankId() {
        return receiverBankId;
    }

    public int getSenderBankId() {
        return senderBankId;
    }
}
