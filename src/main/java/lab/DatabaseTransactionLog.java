package lab;

public class DatabaseTransactionLog implements TransactionLog {
    public DatabaseTransactionLog() {
        System.out.println("DatabaseTransactionLog.ctor is called.");
    }

    @Override
    public void log(String message) {
        System.out.println("Logged to DB: " + message);
    }
}
