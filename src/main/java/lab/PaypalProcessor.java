package lab;

public class PaypalProcessor implements CreditCardProcessor {

    @Override
    public void process(String account, double amount) {
        System.out.println("Processed $" + amount + " via PayPal for account: " + account);
    }
}
