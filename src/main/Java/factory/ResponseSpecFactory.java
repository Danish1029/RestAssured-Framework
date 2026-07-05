package factory;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpecFactory {

    private ResponseSpecFactory() {
    }

    private static ResponseSpecification successResponseSpecification;

    public static ResponseSpecification getSuccessResponseSpecification() {

        if (successResponseSpecification == null) {

            successResponseSpecification = new ResponseSpecBuilder()
            		 .expectStatusCode(200)
            	        .expectContentType(ContentType.JSON)
            	        .build();

        }

        return successResponseSpecification;
    }

}