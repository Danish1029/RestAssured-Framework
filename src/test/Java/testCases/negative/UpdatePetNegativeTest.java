package testCases.negative;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import testDataFactory.PetDataFactory;
import utils.AssertionUtils;

public class UpdatePetNegativeTest extends BaseTest {

    @Test(groups={"pet","negative","regression"})
    public void verifyUpdateInvalidPet() {

        Pet pet =
                PetDataFactory.createPetWithLargeId();

        Response response =
                petAPI.updatePet(pet);

        AssertionUtils.validateClientError(response);

    }

}