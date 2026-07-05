package testCases.positive;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.PetAPI;
import dataProviders.ExcelDataProvider;
import factory.ResponseSpecFactory;
import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import testDataFactory.PetDataFactory;
import utils.AssertionUtils;
import utils.SchemaUtils;
import utils.TestContext;

public class CreatePetTest extends BaseTest {

    PetAPI petAPI = new PetAPI();

    @Test(dataProvider = "PetData",
    	      dataProviderClass = ExcelDataProvider.class)
    	public void verifyCreatePet(HashMap<String, String> data) {

    	  // Create request payload
    	  Pet pet = PetDataFactory.createPet(data);

        // Send POST request
    	  Response response = petAPI.createPet(pet);

        response.then()
        .spec(ResponseSpecFactory.getSuccessResponseSpecification());
        
        // Log response
        logger.info(
                "Status Code : {}",
                response.getStatusCode());
        logger.info(response.asPrettyString());

        // Validate status code
        assertEquals(response.getStatusCode(), 200);
        
        SchemaUtils.validateSchema(response, "PetSchema.json");
        
        // Deserialize response into Pet object
        Pet responsePet = response.as(Pet.class);
  ///      
        // Validate returned data
       assertEquals(responsePet.getId(), pet.getId());
        assertEquals(responsePet.getName(), pet.getName());
        assertEquals(responsePet.getStatus(), pet.getStatus());
        assertEquals(responsePet.getCategory().getName(), pet.getCategory().getName());
///
        AssertionUtils.validateSuccessResponse(
                response,
                "PetSchema.json");
        
        
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