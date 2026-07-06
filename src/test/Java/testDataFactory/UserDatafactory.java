package testDataFactory;

import models.User;
import net.datafaker.Faker;

/**
 * =============================================================================
 * UserDataFactory
 * =============================================================================
 *
 * Generates User Test Data.
 *
 * Used by:
 *
 * • Positive Tests
 * • Negative Tests
 * • Data Driven Tests
 *
 * =============================================================================
 */
public final class UserDatafactory {

    private static final Faker faker = new Faker();

    private UserDatafactory() {
    }

    /**
     * Generates a valid User object.
     *
     * @return User
     */
    @SuppressWarnings("deprecation")
	public static User createUser() {

        return User.builder()
                .id(faker.number().randomNumber())
                .username("User_" + faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(8, 15))
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(1)
                .build();

    }
    
    /**
     * Creates a User object with updated information.
     *
     * Existing Username is preserved because the update API
     * identifies the User using the Username in the URL.
     *
     * @param existingUsername Username of the User to update.
     * @return Updated User object.
     */
    public static User createUpdatedUser(String existingUsername) {

        return User.builder()
                .id(faker.number().randomNumber())
                .username(existingUsername)
                .firstName("Updated_" + faker.name().firstName())
                .lastName("Updated_" + faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(8,15))
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(1)
                .build();

    }

}