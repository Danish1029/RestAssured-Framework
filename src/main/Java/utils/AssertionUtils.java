package utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class AssertionUtils {

    private AssertionUtils() {
    }

    /**
     * Validate HTTP Status Code
     */
    public static void validateStatusCode(Response response, int expectedStatusCode) {

        assertEquals(response.getStatusCode(),
                expectedStatusCode,
                "Status Code Validation Failed");

    }

    /**
     * Validate Content Type
     */
    public static void validateContentType(Response response) {

        assertEquals(response.getContentType(),
                ContentType.JSON.toString(),
                "Content-Type Validation Failed");

    }

    /**
     * Validate Response Time
     */
    public static void validateResponseTime(Response response,
                                            long maxResponseTime) {

        assertTrue(response.time() <= maxResponseTime,
                "Response Time exceeded : "
                        + response.time()
                        + " ms");

    }

    /**
     * Validate Header
     */
    public static void validateHeader(Response response,
                                      String headerName,
                                      String expectedValue) {

        assertEquals(response.getHeader(headerName),
                expectedValue,
                "Header Validation Failed");

    }
    public static void validateSuccessResponse(Response response,
            String schemaName) {

            validateStatusCode(response, 200);

            validateContentType(response);

            validateResponseTime(response, 3000);

      SchemaUtils.validateSchema(response, schemaName);

    }
    public static void validateClientError(Response response) {

        assertTrue(response.getStatusCode() >= 400
                && response.getStatusCode() < 500,
                "Expected 4xx error but got : "
                        + response.getStatusCode());

    }

}