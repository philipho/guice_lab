package lab;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lab.annotation.PaypalProcessor;
import lab.annotation.StripeProcessor;

import java.util.concurrent.ThreadLocalRandom;

// Scope is applied to the class
// Singleton is good for stateless service, shared service, or heavy objects.
@Singleton
public class DefaultBillingService implements BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;
    private final Long id;
    private final Encoder encoder;

    // Need @Inject for injector to inject the parameter components defined in the module file.
    @Inject
    public DefaultBillingService(@PaypalProcessor CreditCardProcessor processor, TransactionLog transactionLog,
                                 Encoder encoder) {
        this.processor = processor;
        this.transactionLog = transactionLog;
        id = ThreadLocalRandom.current().nextLong();
        this.encoder = encoder;
    }

    public void charge(String account, double amount) {
        System.out.println("DefaultBillingSerivce: id=" + id);
        processor.process(account, amount);
        String msg = "Charged " + account + " $" + amount;
        transactionLog.log(msg);
        encoder.encode(msg);
    }

}
