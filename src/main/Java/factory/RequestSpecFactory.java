package factory;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

    private RequestSpecFactory() {
    }

    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {

        if (requestSpecification == null) {

        	RequestSpecBuilder builder = new RequestSpecBuilder()
        	        .setBaseUri(ConfigReader.getBaseURL())
        	        .setContentType(ContentType.JSON)
        	        .setAccept(ContentType.JSON)
        	        .setRelaxedHTTPSValidation()
        	        .addFilter(new RequestLoggingFilter())
        	        .addFilter(new ResponseLoggingFilter());

            // Enable Charles Proxy only if configured
            if (ConfigReader.isProxyEnabled()) {

                builder.setProxy(
                        ConfigReader.getProxyHost(),
                        ConfigReader.getProxyPort());

            }

            requestSpecification = builder.build();
        }

        return requestSpecification;
    }
}