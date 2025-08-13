package lab;

public class StripeProcessor implements CreditCardProcessor {
    @Override
    public void process(String account, double amount) {
        System.out.println("StripeProcessor: account=" + account + ", amount=" + amount);
    }
}
