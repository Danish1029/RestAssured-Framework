package testCases.positive;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import testBase.BaseTest;
import utils.TestContext;

public class GetPetByIdTest extends BaseTest {

    private final PetAPI petAPI = new PetAPI();

    @Test(dependsOnMethods = "testCases.CreatePetTest.verifyCreatePet")
    public void verifyGetPetById() {

        long petId = TestContext.getPetId();
        System.out.println("GetPetByIdTest -> TestContext = " + TestContext.getPetId());

        Response response = petAPI.getPetById(petId);

        logger.info("Before GET -> TestContext = {}", TestContext.getPetId());
        logger.info("Before GET -> Local petId = {}", petId);
        logger.info(
                "Status Code : {}",
                response.getStatusCode());
        logger.info(response.asPrettyString());

        assertEquals(response.getStatusCode(), 200);

        assertEquals(response.jsonPath().getLong("id"), petId);

    }
}