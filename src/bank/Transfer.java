package bank;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Transfer {
    private int senderId;
    private int receiverId;

    public Transfer(int senderId, int receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }
}
