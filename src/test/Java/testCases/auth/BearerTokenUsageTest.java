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

public class BearerTokenUsageTest extends BaseTest {

    @Test
    public void verifyBearerTokenUsage() {

        // Login

        LoginRequest request = LoginRequest.builder()
                .username("emilys")
                .password("emilyspass")
                .build();

        Response loginResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("https://dummyjson.com/auth/login");

        assertEquals(loginResponse.getStatusCode(), 200);

        LoginResponse login = loginResponse.as(LoginResponse.class);

        String token = login.getAccessToken();

        assertNotNull(token);

        logger.info("Access Token : {}", token);

        // Call Protected API

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://dummyjson.com/auth/me");

        logger.info(response.asPrettyString());

        assertEquals(response.getStatusCode(), 200);

        assertEquals(response.jsonPath().getString("username"), "emilys");

    }

}