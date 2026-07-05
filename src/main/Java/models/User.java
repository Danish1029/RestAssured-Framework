package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ============================================================================
 * Model Class : User
 * ============================================================================
 *
 * Represents a User object used by the Swagger PetStore User APIs.
 *
 * This POJO is used for:
 * • Request Serialization
 * • Response Deserialization
 * • Data Driven Testing
 * • API Chaining
 *
 * Lombok annotations generate boilerplate code such as:
 * • Getters
 * • Setters
 * • Constructors
 * • Builder
 *
 * ============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** Unique User Identifier */
    private Long id;

    /** Login Username */
    private String username;

    /** User First Name */
    private String firstName;

    /** User Last Name */
    private String lastName;

    /** Email Address */
    private String email;

    /** Login Password */
    private String password;

    /** Contact Number */
    private String phone;

    /** User Status */
    private Integer userStatus;

}