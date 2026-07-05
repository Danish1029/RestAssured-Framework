package manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;

public final class TokenManager {

    private static final Logger logger = LogManager.getLogger(TokenManager.class);

    private TokenManager() {
    }

    private static String accessToken;
    private static long tokenGeneratedTime;

    // Token validity (15 minutes)
    private static final long TOKEN_VALIDITY = 15 * 60 * 1000;

    /**
     * Returns a valid access token.
     * If no token exists or it has expired, a new token is generated.
     */
    public static String getToken() {

        boolean refreshToken = accessToken != null && isTokenExpired();

        if (accessToken == null || refreshToken) {

            if (refreshToken) {
                logger.info("Access Token expired. Generating a new token...");
            } else {
                logger.info("Generating Access Token...");
            }

            LoginRequest request = LoginRequest.builder()
                    .username(ConfigReader.getProperty("auth.username"))
                    .password(ConfigReader.getProperty("auth.password"))
                    .build();

            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post(ConfigReader.getProperty("auth.url"));

            response.then().statusCode(200);

            LoginResponse loginResponse = response.as(LoginResponse.class);

            accessToken = loginResponse.getAccessToken();

            tokenGeneratedTime = System.currentTimeMillis();

            logger.info("Access Token generated successfully.");

        } else {

            logger.info("Using cached Access Token.");

        }

        return accessToken;
    }

    /**
     * Checks whether the current token has expired.
     */
    private static boolean isTokenExpired() {

        return (System.currentTimeMillis() - tokenGeneratedTime) >= TOKEN_VALIDITY;

    }

    /**
     * Clears the cached token.
     * The next call to getToken() will generate a new one.
     */
    public static void clearToken() {

        accessToken = null;
        tokenGeneratedTime = 0;

        logger.info("Cached Access Token cleared.");

    }

}