package testCases.negative;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.Pet;
import testBase.BaseTest;
import testDataFactory.PetDataFactory;
import utils.AssertionUtils;

/**
 * ============================================================================
 * Negative Test Cases for Create Pet API
 * ============================================================================
 *
 * Objective
 * ---------
 * Validate API behaviour using Invalid Payloads.
 *
 * ============================================================================
 */
public class CreatePetNegativeTest extends BaseTest {

    @Test(groups = {"pet","negative","regression"})
    public void verifyCreatePetWithoutName() {

        // Arrange
        Pet pet = PetDataFactory.createPetWithoutName();

        // Act
        Response response = petAPI.createPet(pet);

        // Assert
        AssertionUtils.validateClientError(response);

    }

    @Test(groups = {"pet","negative","regression"})
    public void verifyCreatePetWithoutCategory() {

        Pet pet = PetDataFactory.createPetWithoutCategory();

        Response response = petAPI.createPet(pet);

        AssertionUtils.validateClientError(response);

    }

    @Test(groups = {"pet","negative","regression"})
    public void verifyCreatePetWithInvalidStatus() {

        Pet pet = PetDataFactory.createPetWithInvalidStatus();

        Response response = petAPI.createPet(pet);

        AssertionUtils.validateClientError(response);

    }

    @Test(groups = {"pet","negative","regression"})
    public void verifyCreatePetWithNegativeId() {

        Pet pet = PetDataFactory.createPetWithNegativeId();

        Response response = petAPI.createPet(pet);

        AssertionUtils.validateClientError(response);

    }

    @Test(groups = {"pet","negative","regression"})
    public void verifyCreatePetWithLargeId() {

        Pet pet = PetDataFactory.createPetWithLargeId();

        Response response = petAPI.createPet(pet);

        AssertionUtils.validateClientError(response);

    }

}