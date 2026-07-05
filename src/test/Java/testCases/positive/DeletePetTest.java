package testCases.positive;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import testBase.BaseTest;
import utils.TestContext;
import utils.AssertionUtils;

public class DeletePetTest extends BaseTest {

    private final PetAPI petAPI = new PetAPI();

    @Test(dependsOnMethods = "testCases.CreatePetTest.verifyCreatePet")
    public void verifyDeletePet() {

        long petId = TestContext.getPetId();

        Response response = petAPI.deletePet(petId);
        logger.info(
                "Status Code : {}",
                response.getStatusCode());
        logger.info(response.asPrettyString());

        AssertionUtils.validateStatusCode(response, 200);

        assertEquals(response.jsonPath().getString("message"),
                String.valueOf(petId));

        logger.info("Deleted Pet ID : {}", petId);
        
        Response getResponse = petAPI.getPetById(petId);

        AssertionUtils.validateStatusCode(getResponse, 404);

        logger.info("Verified Pet no longer exists.");

    }

}