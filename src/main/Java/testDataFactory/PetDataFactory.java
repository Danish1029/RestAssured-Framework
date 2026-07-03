package testDataFactory;

import java.util.Arrays;

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

}