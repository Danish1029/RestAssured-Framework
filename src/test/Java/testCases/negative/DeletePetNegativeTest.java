package testCases.negative;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testBase.BaseTest;
import utils.AssertionUtils;

public class DeletePetNegativeTest extends BaseTest {

    @Test(groups={"pet","negative","regression"})
    public void verifyDeleteInvalidPet() {

        Response response =
                petAPI.deletePet(Long.MAX_VALUE);

        AssertionUtils.validateClientError(response);

    }

}