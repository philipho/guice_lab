package lab;

public class DatabaseTransactionLog implements TransactionLog {

    @Override
    public void log(String message) {
        System.out.println("Logged to DB: " + message);
    }
}
