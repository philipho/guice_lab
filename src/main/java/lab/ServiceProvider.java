package lab;

import jakarta.inject.Inject;
import jakarta.inject.Provider;

public class ServiceProvider implements Provider<BillingService> {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public ServiceProvider(CreditCardProcessor processor, TransactionLog transactionLog) {
        System.out.println("ServiceProvider.ctor is called.");
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public BillingService get() {
        System.out.println("ServiceProvider.get() is called");
        return new DefaultBillingService(processor, transactionLog);
    }
}
