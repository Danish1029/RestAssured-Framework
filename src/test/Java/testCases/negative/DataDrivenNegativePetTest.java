package testCases.negative;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import dataProviders.NegativePetDataProvider;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import testBase.BaseTest;

/**
 * ============================================================================
 * Executes negative Pet API scenarios from Excel.
 *
 * Each Excel row represents one test scenario.
 * ============================================================================
 */
public class DataDrivenNegativePetTest extends BaseTest {

    @Test(
            dataProvider = "NegativePetData",
            dataProviderClass = NegativePetDataProvider.class,
            groups = {"pet","negative","datadriven"}
    )
    public void verifyNegativePetCreation(HashMap<String,String> data) {

        // Arrange
        Pet pet = Pet.builder()
                .id(Long.parseLong(data.get("id")))
                .name(data.get("petName"))
                .status(data.get("status"))
                .category(
                        Category.builder()
                                .id(Long.parseLong(data.get("categoryId")))
                                .name(data.get("categoryName"))
                                .build())
                .build();

        // Act
        Response response = petAPI.createPet(pet);

        // Assert
        assertEquals(
                response.getStatusCode(),
                Integer.parseInt(data.get("expectedStatus"))
        );

    }
}