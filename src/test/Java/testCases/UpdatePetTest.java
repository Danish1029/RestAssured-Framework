package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import testDataFactory.PetDataFactory;
import utilities.TestContext;

public class UpdatePetTest extends BaseTest {

    private final PetAPI petAPI = new PetAPI();

    @Test(dependsOnMethods = "testCases.CreatePetTest.verifyCreatePet")
    public void verifyUpdatePet() {

        // Create updated Pet object
        Pet pet = PetDataFactory.createPet();

        // Use the existing Pet ID created in CreatePetTest
        pet.setId(TestContext.getPetId());

        // Update values
        pet.setName("Updated_Pet");
        pet.setStatus("sold");

        // Send PUT request
        Response response = petAPI.updatePet(pet);

        logger.info(response.asPrettyString());

        // Status code validation
        assertEquals(response.getStatusCode(), 200);

        // Deserialize response
        Pet updatedPet = response.as(Pet.class);

        // Validate updated data
        assertEquals(updatedPet.getId(), TestContext.getPetId());
        assertEquals(updatedPet.getName(), "Updated_Pet");
        assertEquals(updatedPet.getStatus(), "sold");
    }
}