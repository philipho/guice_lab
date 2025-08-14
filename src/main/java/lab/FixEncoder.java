package lab;

import jakarta.inject.Inject;

public class FixEncoder implements Encoder {
    private final String encoderVersion;
    private final Config config;

    @Inject
    public FixEncoder(String encoderVersion, Config config) {
        this.encoderVersion = encoderVersion;
        this.config = config;
    }

    public byte[] encode(String msg) {
        String output = String.format("FixEncoder: version=%s msg=%s", encoderVersion, msg);
        System.out.println(output);
        return msg.getBytes();
    }
}
