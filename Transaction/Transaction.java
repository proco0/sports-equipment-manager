package Main.Transaction;
import Main.Equipment.Equipment;
import Main.User.User;

public class Transaction {
    private String transactionId;
    private User user;
    private Equipment equipment;
    private int quantity;
    private boolean collected;

    public Transaction(String transactionId, User user, Equipment equipment, int quantity) {
        this.transactionId = transactionId;
        this.user = user;
        this.equipment = equipment;
        this.quantity = quantity;
        this.collected = false;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public User getUser() {
        return user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isCollected() {
        return collected;
    }
}

