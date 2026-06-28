package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    //==========================
    // Environment Names
    //==========================

    public static final String QA = "qa";
    public static final String UAT = "uat";
    public static final String PROD = "prod";

    //==========================
    // Configuration
    //==========================

    public static final String CONFIG_FOLDER = "config/";
    public static final String PROPERTY_EXTENSION = ".properties";

    //==========================
    // Property Keys
    //==========================

    public static final String BASE_URL = "base.url";
    public static final String ENVIRONMENT = "environment";
    public static final String CONNECT_TIMEOUT = "connect.timeout";
    public static final String READ_TIMEOUT = "read.timeout";

    //==========================
    // Content Types
    //==========================

    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_XML = "application/xml";

    //==========================
    // Report Paths
    //==========================

    public static final String EXTENT_REPORT_FOLDER = "reports/";
    public static final String ALLURE_RESULTS = "allure-results/";

}