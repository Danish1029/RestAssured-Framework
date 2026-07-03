package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import testDataFactory.PetDataFactory;
import utilities.TestContext;

public class CreatePetTest extends BaseTest {

    PetAPI petAPI = new PetAPI();

    @Test
    public void verifyCreatePet() {

    	  // Create request payload
        Pet pet = PetDataFactory.createPet();

        // Send POST request
        Response response = petAPI.createPet(pet);

        // Log response
        logger.info(response.asPrettyString());

        // Validate status code
        assertEquals(response.getStatusCode(), 200);
        

        // Deserialize response into Pet object
        Pet responsePet = response.as(Pet.class);
        
        // Validate returned data
        assertEquals(responsePet.getId(), pet.getId());
        assertEquals(responsePet.getName(), pet.getName());
        assertEquals(responsePet.getStatus(), pet.getStatus());
        assertEquals(responsePet.getCategory().getName(), pet.getCategory().getName());

 /*       assertEquals(response.jsonPath().getString("name"), pet.getName());

        assertEquals(response.jsonPath().getString("status"), "available");
        long petId = response.jsonPath().getLong("id");
*/
        TestContext.setPetId(responsePet.getId());
        
        System.out.println("CreatePetTest -> TestContext = " + TestContext.getPetId());
        logger.info("After setPetId() -> TestContext = {}", TestContext.getPetId());
        logger.info("Created Pet ID : {}", pet.getId());
        

        logger.info("Created Pet ID : " + responsePet.getId());
    }

}