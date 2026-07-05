package testCases.auth;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import testBase.BaseTest;

public class BasicAuthenticationTest extends BaseTest {

    @Test
    public void verifyBasicAuthentication() {

        Response response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .auth()
                .preemptive()
                .basic("admin", "password123")
                .when()
                .get("https://httpbin.org/basic-auth/admin/password123");

        logger.info(response.asPrettyString());

        assertEquals(response.getStatusCode(), 200);

        assertTrue(response.jsonPath().getBoolean("authenticated"));

        assertEquals(response.jsonPath().getString("user"), "admin");

    }

}