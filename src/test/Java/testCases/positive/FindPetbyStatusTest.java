package testCases.positive;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import utils.AssertionUtils;

/**
 * ============================================================================
 * Test Class : FindPetByStatusTest
 * ============================================================================
 *
 * Objective
 * ---------
 * Validate that the Pet Store API correctly returns all pets
 * matching a given status.
 *
 * API Under Test
 * --------------
 * GET /pet/findByStatus
 *
 * Sample Request
 * --------------
 * /pet/findByStatus?status=available
 *
 * Validations
 * -----------
 * 1. Status Code
 * 2. Content Type
 * 3. Response Time
 * 4. JSON Schema
 * 5. Response contains at least one Pet
 * 6. Every returned Pet has the requested status
 *
 * Author : Danish
 * Framework : REST Assured + TestNG
 * ============================================================================
 */
public class FindPetbyStatusTest extends BaseTest {

    /**
     * API class responsible for Pet endpoints.
     */
    private final PetAPI petAPI = new PetAPI();

    @Test(groups = { "smoke", "regression", "pet", "positive" })
    public void verifyFindPetByStatus() {

        // ---------------------------------------------------------------------
        // Arrange
        // ---------------------------------------------------------------------

        String expectedStatus = "available";

        // ---------------------------------------------------------------------
        // Act
        // ---------------------------------------------------------------------

        Response response = petAPI.getPetsByStatus(expectedStatus);
        logger.info(
                "Status Code : {}",
                response.getStatusCode());
        logger.info(response.asPrettyString());

        // ---------------------------------------------------------------------
        // Assert : Generic API validations
        // ---------------------------------------------------------------------

        AssertionUtils.validateSuccessResponse(
                response,
                "PetArraySchema.json");

        // ---------------------------------------------------------------------
        // Convert JSON Array into Java List of Pet Objects.
        // ---------------------------------------------------------------------

        List<Pet> pets = response.jsonPath().getList("", Pet.class);

        // API should return at least one matching Pet.
        assertFalse(
                pets.isEmpty(),
                "No Pets were returned for status : " + expectedStatus);

        // Validate every returned Pet.
        for (Pet pet : pets) {

            assertEquals(
                    pet.getStatus(),
                    expectedStatus,
                    "Unexpected Pet Status Found");

        }

        logger.info(
                "Successfully validated {} Pets with status '{}'",
                pets.size(),
                expectedStatus);

    }

}