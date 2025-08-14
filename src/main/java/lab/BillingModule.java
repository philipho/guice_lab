package lab;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
//        bind(CreditCardProcessor.class).annotatedWith(Names.named("stripe")).to(StripeProcessor.class);
//        bind(CreditCardProcessor.class).annotatedWith(Names.named("paypal")).to(PaypalProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(lab.annotation.StripeProcessor.class).to(StripeProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(lab.annotation.PaypalProcessor.class).to(PaypalProcessor.class);
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(BillingService.class).to(DefaultBillingService.class); //.in(Singleton.class);
    }
}
