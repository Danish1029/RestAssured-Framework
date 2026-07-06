package testCases.positive.user;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.User;
import testBase.BaseTest;
import utils.UserContext;
import utils.AssertionUtils;

/**
 * =============================================================================
 * GetUserTest
 * =============================================================================
 *
 * Validates retrieval of an existing User.
 *
 * API Under Test
 * --------------
 * GET /user/{username}
 *
 * =============================================================================
 */
public class GetUserTest extends BaseTest {

    @Test(
            dependsOnMethods = "testCases.positive.user.CreateUserTest.verifyCreateUser",
            groups = {
                    "user",
                    "positive",
                    "smoke",
                    "regression"
            })
    public void verifyGetUser() {

        // ---------------------------------------------------------------------
        // Arrange
        // ---------------------------------------------------------------------

        String username = UserContext.getUsername();

        logger.info("Fetching User : {}", username);

        // ---------------------------------------------------------------------
        // Act
        // ---------------------------------------------------------------------

        Response response = userAPI.getUser(username);

        logger.info("Status Code : {}", response.getStatusCode());
        logger.debug(response.asPrettyString());

        // ---------------------------------------------------------------------
        // Assert
        // ---------------------------------------------------------------------

        AssertionUtils.validateSuccessResponse(
                response,
                "UserSchema.json");

        // Deserialize response into POJO
        User responseUser = response.as(User.class);

        // Validate important business fields
        assertEquals(
                responseUser.getUsername(),
                username,
                "Username mismatch");

        assertEquals(
                responseUser.getId(),
                UserContext.getUserId(),
                "User ID mismatch");

        logger.info("Successfully validated User : {}", username);

    }

}