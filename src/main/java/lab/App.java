package lab;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
    public static void main(String[] args) {
        // BillingModule tells you how to wire the components
        // Guice.createInjector creates the components according to the module plan
        // The results objects are inside the "Injector" DI container.
        Injector injector = Guice.createInjector(new BillingModule());

        // Get component from the container, e.g. injector
        BillingService billingService1 = injector.getInstance(BillingService.class);

        // Do stuff with the component
        billingService1.charge("user123", 128.23);

        // Get component from the container, e.g. injector
        BillingService billingService2 = injector.getInstance(BillingService.class);

        // Do stuff with the component
        billingService2.charge("user678", 3213.89);
    }
}
