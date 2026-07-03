package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import testBase.BaseTest;

public class PetTest extends BaseTest {

	PetAPI petAPI = new PetAPI();

	@Test
	public void verifyFindAvailablePets() {

	    Response response = petAPI.findPetsByStatus("available");

	    logger.info(response.asPrettyString());

	    assertEquals(response.getStatusCode(), 200);

    }

}