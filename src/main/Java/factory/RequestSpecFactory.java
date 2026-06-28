package factory;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

    private RequestSpecFactory() {
    }

    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {

        if (requestSpecification == null) {

            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(ConfigReader.getBaseURL())
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .build();

        }

        return requestSpecification;
    }
}