package api;

import java.util.HashMap;
import java.util.Map;

import base.BaseAPI;
import endpoints.Routes;
import io.restassured.response.Response;
import models.User;

/**
 * =============================================================================
 * UserAPI
 * =============================================================================
 *
 * Purpose
 * -------
 * Encapsulates all User related API operations.
 *
 * Benefits
 * --------
 * • Test classes never call RestAssured directly.
 * • Centralized User API implementation.
 * • Easy maintenance.
 * • High reusability.
 *
 * =============================================================================
 */
public class UserAPI extends BaseAPI {

    /**
     * Creates a new User.
     *
     * @param user Request Payload
     * @return API Response
     */
    public Response createUser(User user) {

        return post(Routes.CREATE_USER, user);

    }

    /**
     * Retrieves User using Username.
     *
     * @param username Username
     * @return API Response
     */
    public Response getUser(String username) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("username", username);

        return get(
                Routes.GET_USER,
                pathParams,
                null);

    }

    /**
     * Updates an existing User.
     *
     * @param username Username
     * @param user Updated User Payload
     * @return API Response
     */
    public Response updateUser(String username,
                               User user) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("username", username);

        return put(
                Routes.UPDATE_USER,
                user,
                pathParams);

    }

    /**
     * Deletes User.
     *
     * @param username Username
     * @return API Response
     */
    public Response deleteUser(String username) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("username", username);

        return delete(
                Routes.DELETE_USER,
                pathParams);

    }

}