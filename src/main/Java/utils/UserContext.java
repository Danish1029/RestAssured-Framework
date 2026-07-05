package utils;

/**
 * =============================================================================
 * UserContext
 * =============================================================================
 *
 * Stores User related information shared across multiple User Tests.
 *
 * =============================================================================
 */
public final class UserContext {

    private UserContext() {
    }

    private static String username;

    public static void setUsername(String userName) {

        username = userName;

    }

    public static String getUsername() {

        return username;

    }

}