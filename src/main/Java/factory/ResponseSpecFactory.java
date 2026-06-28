package factory;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpecFactory {

    private ResponseSpecFactory() {
    }

    private static ResponseSpecification responseSpecification;

    public static ResponseSpecification getResponseSpecification() {

        if (responseSpecification == null) {

            responseSpecification = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .build();

        }

        return responseSpecification;
    }
}