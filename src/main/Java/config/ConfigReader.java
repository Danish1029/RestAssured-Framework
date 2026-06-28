package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constants.FrameworkConstants;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {
    }

    private static void loadProperties() {

        String environment = System.getProperty("env");

        if (environment == null || environment.trim().isEmpty()) {
            environment = "qa";
        }

        String fileName = "config/" + environment.toLowerCase() + ".properties";

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Configuration file not found : " + fileName);
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration file : " + fileName, e);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Property '" + key + "' not found.");
        }

        return value.trim();
    }

    public static String getBaseURL() {
        return getProperty("base.url");
    }

    public static String getEnvironment() {
    	return getProperty(FrameworkConstants.BASE_URL);
    }

    public static int getConnectTimeout() {
        return Integer.parseInt(getProperty("connect.timeout"));
    }

    public static int getReadTimeout() {
        return Integer.parseInt(getProperty("read.timeout"));
    }
}