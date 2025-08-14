package lab;

public class PaypalProcessor implements CreditCardProcessor {
    public PaypalProcessor() {
        System.out.println("PaypalProcessor.ctor is called.");
    }

    @Override
    public void process(String account, double amount) {
        System.out.println("Processed $" + amount + " via PayPal for account: " + account);
    }
}
