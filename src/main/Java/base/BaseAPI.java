package base;

import factory.RequestSpecFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class BaseAPI {

    protected Response get(String endpoint) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .when()
                .get(endpoint);

    }

    protected Response get(String endpoint,
                           Map<String, Object> pathParams) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .pathParams(pathParams)
                .when()
                .get(endpoint);

    }

    protected Response post(String endpoint,
                            Object payload) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .body(payload)
                .when()
                .post(endpoint);

    }

    protected Response put(String endpoint,
                           Object payload,
                           Map<String,Object> pathParams) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .pathParams(pathParams)
                .body(payload)
                .when()
                .put(endpoint);

    }

    protected Response patch(String endpoint,
                             Object payload,
                             Map<String,Object> pathParams) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .pathParams(pathParams)
                .body(payload)
                .when()
                .patch(endpoint);

    }

    protected Response delete(String endpoint,
                              Map<String,Object> pathParams) {

        return RestAssured
                .given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .pathParams(pathParams)
                .when()
                .delete(endpoint);

    }

}