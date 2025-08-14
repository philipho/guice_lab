package lab;

import jakarta.inject.Inject;

public class Config {
    @Inject
    public Config() {
        System.out.println("Config: ctor");
    }
}
