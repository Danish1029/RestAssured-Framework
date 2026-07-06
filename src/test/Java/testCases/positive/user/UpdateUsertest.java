package testCases.positive.user;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.User;
import testBase.BaseTest;
import testDataFactory.UserDatafactory;
import utils.AssertionUtils;
import utils.UserContext;

/**
 * =============================================================================
 * UpdateUserTest
 * =============================================================================
 *
 * Validates updating an existing User.
 *
 * Flow
 * ----
 * 1. Read Username from UserContext
 * 2. Update User
 * 3. Verify Update Response
 * 4. Retrieve Updated User
 * 5. Validate Updated Fields
 *
 * =============================================================================
 */
public class UpdateUsertest extends BaseTest {

    @Test(
            dependsOnMethods = "testCases.positive.user.GetUserTest.verifyGetUser",
            groups = {
                    "user",
                    "positive",
                    "regression"
            })
    public void verifyUpdateUser() {

        // ---------------------------------------------------------------------
        // Arrange
        // ---------------------------------------------------------------------

        String username = UserContext.getUsername();

        User updatedUser =
                UserDatafactory.createUpdatedUser(username);

        logger.info("Updating User : {}", username);

        // ---------------------------------------------------------------------
        // Act
        // ---------------------------------------------------------------------

        Response updateResponse =
                userAPI.updateUser(username, updatedUser);

        logger.info("Update Status : {}",
                updateResponse.getStatusCode());

        logger.debug(updateResponse.asPrettyString());

        // ---------------------------------------------------------------------
        // Assert Update Response
        // ---------------------------------------------------------------------

        AssertionUtils.validateStatusCode(updateResponse, 200);

        // ---------------------------------------------------------------------
        // Verify Data Persistence
        // ---------------------------------------------------------------------

        Response getResponse =
                userAPI.getUser(username);

        AssertionUtils.validateSuccessResponse(
                getResponse,
                "UserSchema.json");

        User actualUser =
                getResponse.as(User.class);

        assertEquals(
                actualUser.getFirstName(),
                updatedUser.getFirstName());

        assertEquals(
                actualUser.getLastName(),
                updatedUser.getLastName());

        assertEquals(
                actualUser.getEmail(),
                updatedUser.getEmail());

        logger.info("Successfully updated User : {}", username);

    }

}