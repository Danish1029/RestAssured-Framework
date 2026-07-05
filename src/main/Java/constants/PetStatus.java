package constants;

/**
 * ============================================================================
 * Enum : PetStatus
 * ============================================================================
 *
 * Represents all valid Pet status values supported by Swagger PetStore API.
 *
 * Using Enum avoids:
 * ------------------
 * • Typing mistakes
 * • Magic Strings
 * • Invalid values
 *
 * Example:
 *
 * PetStatus.AVAILABLE
 * PetStatus.PENDING
 * PetStatus.SOLD
 *
 * ============================================================================
 */
public enum PetStatus {

    AVAILABLE("available"),

    PENDING("pending"),

    SOLD("sold");

    /**
     * Actual status value expected by the API.
     */
    private final String value;

    PetStatus(String value) {

        this.value = value;

    }

    /**
     * Returns API compatible String.
     *
     * Example:
     * AVAILABLE -> "available"
     */
    public String getValue() {

        return value;

    }

}