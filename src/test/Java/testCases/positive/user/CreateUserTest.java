package testCases.positive.user;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.User;
import testBase.BaseTest;
import testDataFactory.UserDatafactory;
import utils.AssertionUtils;
import utils.UserContext;

/**
 * =============================================================================
 * CreateUserTest
 * =============================================================================
 *
 * Validates User Creation API.
 *
 * =============================================================================
 */
public class CreateUserTest extends BaseTest {

    @Test(groups = {
            "user",
            "positive",
            "smoke",
            "regression"
    })
    public void verifyCreateUser() {

        // ---------------------------------------------------------------------
        // Arrange
        // ---------------------------------------------------------------------

        User user = UserDatafactory.createUser();

        // ---------------------------------------------------------------------
        // Act
        // ---------------------------------------------------------------------

        Response response = userAPI.createUser(user);

        logger.info("Status Code : {}", response.getStatusCode());
        logger.debug(response.asPrettyString());

        // ---------------------------------------------------------------------
        // Assert
        // ---------------------------------------------------------------------

        AssertionUtils.validateStatusCode(response, 200);
        AssertionUtils.validateContentType(response);
        AssertionUtils.validateResponseTime(response, 3000);

        // Store Username for API Chaining.
        UserContext.setUsername(user.getUsername());
        UserContext.setUserId(user.getId());
        logger.info("Created Username : {}", user.getUsername());

    }

}