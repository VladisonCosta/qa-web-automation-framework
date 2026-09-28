package br.com.vladison.qa.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties not found");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load test configuration", e);
        }
    }

    private Config() {}

    public static String get(String key) {
        String systemValue = System.getProperty(key);
        return systemValue != null ? systemValue : PROPERTIES.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }
}
