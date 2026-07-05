package testDataFactory;

import java.util.Arrays;
import java.util.HashMap;

import models.Category;
import models.Pet;
import models.Tag;
import net.datafaker.Faker;

public final class PetDataFactory {

    private static final Faker faker = new Faker();

    private PetDataFactory() {
    }

    public static Pet createPet() {

        return Pet.builder()
        		.id(faker.number().numberBetween(100000L, 999999L))
                .category(
                        Category.builder()
                                .id(1L)
                                .name("Dogs")
                                .build())
                .name("Pet_" + faker.animal().name())
                .photoUrls(Arrays.asList(
                        "https://petstore.com/image1.jpg",
                        "https://petstore.com/image2.jpg"))
                .tags(Arrays.asList(
                        Tag.builder()
                                .id(1L)
                                .name("Friendly")
                                .build()))
                .status("available")
                .build();
    }
    
    public static Pet createPet(HashMap<String, String> data) {

        return Pet.builder()
                .id(Long.parseLong(data.get("id")))
                .category(
                        Category.builder()
                                .id(Long.parseLong(data.get("categoryId")))
                                .name(data.get("categoryName"))
                                .build())
                .name(data.get("petName"))
                .photoUrls(Arrays.asList(
                        data.get("photoUrl1"),
                        data.get("photoUrl2")))
                .tags(Arrays.asList(
                        Tag.builder()
                                .id(Long.parseLong(data.get("tagId")))
                                .name(data.get("tagName"))
                                .build()))
                .status(data.get("status"))
                .build();

    }
    /**
     * Creates a Pet object without Name.
     * Used for Negative API Testing.
     */
    public static Pet createPetWithoutName() {

        Pet pet = createPet();

        pet.setName(null);

        return pet;
    }

    /**
     * Creates a Pet object with Empty Name.
     */
    public static Pet createPetWithEmptyName() {

        Pet pet = createPet();

        pet.setName("");

        return pet;
    }

    /**
     * Creates a Pet object without Category.
     */
    public static Pet createPetWithoutCategory() {

        Pet pet = createPet();

        pet.setCategory(null);

        return pet;
    }

    /**
     * Creates a Pet object with Invalid Status.
     */
    public static Pet createPetWithInvalidStatus() {

        Pet pet = createPet();

        pet.setStatus("INVALID_STATUS");

        return pet;
    }

    /**
     * Creates a Pet object with Negative ID.
     */
    public static Pet createPetWithNegativeId() {

        Pet pet = createPet();

        pet.setId(-1L);

        return pet;
    }

    /**
     * Creates a Pet object with Zero ID.
     */
    public static Pet createPetWithZeroId() {

        Pet pet = createPet();

        pet.setId(0L);

        return pet;
    }

    /**
     * Creates a Pet object with Very Large ID.
     */
    public static Pet createPetWithLargeId() {

        Pet pet = createPet();

        pet.setId(Long.MAX_VALUE);

        return pet;
    }

    /**
     * Creates a Pet object having Special Characters.
     */
    public static Pet createPetWithSpecialCharacters() {

        Pet pet = createPet();

        pet.setName("@#$%^&*()_+?><");

        return pet;
    }

    /**
     * Creates a Pet object having Very Long Name.
     */
    public static Pet createPetWithLongName() {

        Pet pet = createPet();

        pet.setName("A".repeat(300));

        return pet;
    }

}