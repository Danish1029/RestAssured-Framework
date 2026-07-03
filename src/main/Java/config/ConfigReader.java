package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {
    }

    private static void loadProperties() {

        String fileName = "config/qa.properties";

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + fileName);
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration file: " + fileName, e);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Property '" + key + "' not found in qa.properties.");
        }

        return value.trim();
    }

    public static String getBaseURL() {
        return getProperty("base.url");
    }

    public static String getEnvironment() {
        return "QA";
    }

    public static int getConnectTimeout() {
        return Integer.parseInt(getProperty("connect.timeout"));
    }

    public static int getReadTimeout() {
        return Integer.parseInt(getProperty("read.timeout"));
    }
    
    public static boolean isProxyEnabled() {
        return Boolean.parseBoolean(getProperty("proxy.enabled"));
    }

    public static String getProxyHost() {
        return getProperty("proxy.host");
    }

    public static int getProxyPort() {
        return Integer.parseInt(getProperty("proxy.port"));
    }
}