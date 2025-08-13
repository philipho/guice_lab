package lab;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab.annotation.PaypalProcessor;
import lab.annotation.StripeProcessor;

public class PaymentService {
    @Inject
//    @Named("paypal")
    @PaypalProcessor
    CreditCardProcessor paypalProcessor;

    @Inject
//    @Named("stripe")
    @StripeProcessor
    CreditCardProcessor stripeProcessor;
}
