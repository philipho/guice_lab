package lab;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import jakarta.inject.Named;

public class BillingModule extends AbstractModule {
    private Config config;

    public BillingModule(Config config) {
        this.config = config;
    }

    @Override
    protected void configure() {
//        bind(CreditCardProcessor.class).annotatedWith(Names.named("stripe")).to(StripeProcessor.class);
//        bind(CreditCardProcessor.class).annotatedWith(Names.named("paypal")).to(PaypalProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(lab.annotation.StripeProcessor.class).to(StripeProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(lab.annotation.PaypalProcessor.class).to(PaypalProcessor.class);
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(BillingService.class).to(DefaultBillingService.class); //.in(Singleton.class);
        bind(String.class).annotatedWith(Names.named("encoderVersion")).toInstance("named-binding-version-2.3");
        bind(Config.class).toInstance(config);
    }

    // @Provides will do the bind(Encoder.class).to(FixEncoder.class)
    @Provides
    Encoder provideEncoder(@Named("encoderVersion") String encoderVersion) {
        return new FixEncoder(encoderVersion, config);
    }
}
