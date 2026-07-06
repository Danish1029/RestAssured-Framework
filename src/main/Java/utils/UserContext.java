package utils;

/**
 * =============================================================================
 * UserContext
 * =============================================================================
 *
 * Stores User related information that needs to be shared across multiple test
 * classes during API chaining.
 *
 * Example Flow:
 *
 * Create User
 *      ↓
 * Store Username & User ID
 *      ↓
 * Get User
 *      ↓
 * Update User
 *      ↓
 * Delete User
 *
 * =============================================================================
 */
public final class UserContext {

    private UserContext() {
    }

    /** Username used during API chaining */
    private static String username;

    /** User ID used for validation */
    private static Long userId;

    public static void setUsername(String username) {
        UserContext.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUserId(Long userId) {
        UserContext.userId = userId;
    }

    public static Long getUserId() {
        return userId;
    }

    /**
     * Clears stored values after execution.
     * Useful when executing suites in sequence.
     */
    public static void clear() {

        username = null;
        userId = null;

    }

}