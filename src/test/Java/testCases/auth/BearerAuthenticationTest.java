package testCases.auth;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;
import testBase.BaseTest;

public class BearerAuthenticationTest extends BaseTest {

    @Test
    public void verifyBearerAuthentication() {

        LoginRequest request = LoginRequest.builder()
                .username("emilys")
                .password("emilyspass")
                .build();

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("https://dummyjson.com/auth/login");

        logger.info(response.asPrettyString());

        assertEquals(response.getStatusCode(), 200);

        LoginResponse loginResponse = response.as(LoginResponse.class);

        assertNotNull(loginResponse.getAccessToken());

        logger.info("Access Token : {}", loginResponse.getAccessToken());

    }

}