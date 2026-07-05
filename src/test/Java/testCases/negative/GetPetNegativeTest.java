package testCases.negative;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testBase.BaseTest;
import utils.AssertionUtils;

public class GetPetNegativeTest extends BaseTest {

    @Test(groups={"pet","negative","regression"})
    public void verifyInvalidPetId() {

        Response response =
                petAPI.getPetById(-100);

        AssertionUtils.validateClientError(response);

    }

    @Test(groups={"pet","negative","regression"})
    public void verifyHugePetId() {

        Response response =
                petAPI.getPetById(Long.MAX_VALUE);

        AssertionUtils.validateClientError(response);

    }

}