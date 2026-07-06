package testCases.positive;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.PetAPI;
import io.restassured.response.Response;
import testBase.BaseTest;

public class PetTest extends BaseTest {

	PetAPI petAPI = new PetAPI();

	@Test(
		    groups = {
		        "pet",
		        "smoke",
		        "regression"
		    }
		)
	public void verifyFindAvailablePets() {

	    Response response = petAPI.findPetsByStatus("available");
	    logger.info(
	            "Status Code : {}",
	            response.getStatusCode());
	    logger.info(response.asPrettyString());

	    assertEquals(response.getStatusCode(), 200);

    }

}