package Main.Transaction;

public class TransactionManager {
    private static final int MAX_TRANSACTIONS = 1000;
    private Transaction[] transactionList; // batayaaa Transaction [] 
    private int size;

    public TransactionManager() {
        this.transactionList = new Transaction[MAX_TRANSACTIONS]; // iniialized 
        this.size = 0;
    }

    public void addTransaction(Transaction transaction) {
        if (size < MAX_TRANSACTIONS) {
            transactionList[size++] = transaction;
        } else {
            System.out.println("Transaction storage is full");
        }
    }
}
