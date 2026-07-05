package base;

import java.util.Map;

import auth.AuthFactory;
import auth.AuthType;
import factory.RequestSpecFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * =============================================================================
 * BaseAPI
 * =============================================================================
 *
 * Purpose
 * -------
 * Base class for all API classes in the framework.
 *
 * Responsibilities
 * ----------------
 * • Creates a common RequestSpecification
 * • Applies Authentication
 * • Applies Path Parameters
 * • Applies Query Parameters
 * • Executes HTTP Requests
 *
 * Benefits
 * --------
 * • Eliminates duplicate REST Assured code
 * • Centralizes authentication
 * • Easy to maintain
 * • Follows DRY Principle
 * • Enterprise Ready
 *
 * All API classes (PetAPI, UserAPI, StoreAPI...)
 * should extend this class.
 *
 * =============================================================================
 */
public abstract class BaseAPI {

    /**
     * Builds the RequestSpecification used by every HTTP request.
     *
     * Steps:
     * 1. Create RequestSpecification
     * 2. Apply framework Request Specification
     * 3. Apply Authentication
     * 4. Apply Path Parameters
     * 5. Apply Query Parameters
     *
     * @param authType Authentication type.
     * @param pathParams Path parameters (optional).
     * @param queryParams Query parameters (optional).
     * @param credentials Authentication credentials (optional).
     * @return Configured RequestSpecification.
     */
    private RequestSpecification buildRequest(
            AuthType authType,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams,
            String... credentials) {

        // Create base request
        RequestSpecification request = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .spec(RequestSpecFactory.getRequestSpecification());

        // Apply Authentication
        request = AuthFactory.applyAuthentication(
                request,
                authType,
                credentials);

        // Apply Path Parameters
        if (pathParams != null && !pathParams.isEmpty()) {
            request.pathParams(pathParams);
        }

        // Apply Query Parameters
        if (queryParams != null && !queryParams.isEmpty()) {
            request.queryParams(queryParams);
        }

        return request;

    }

    // =========================================================================
    // GET
    // =========================================================================

    /**
     * Executes HTTP GET request without parameters.
     */
    protected Response get(String endpoint) {

        return get(endpoint, null, null);

    }

    /**
     * Executes HTTP GET request.
     *
     * @param endpoint API endpoint
     * @param pathParams Path parameters
     * @param queryParams Query parameters
     * @return Response
     */
    protected Response get(
            String endpoint,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams) {

        return buildRequest(
                AuthType.NO_AUTH,
                pathParams,
                queryParams)
                .when()
                .get(endpoint);

    }

    // =========================================================================
    // POST
    // =========================================================================

    /**
     * Executes HTTP POST request.
     *
     * @param endpoint API endpoint
     * @param payload Request body
     * @return Response
     */
    protected Response post(
            String endpoint,
            Object payload) {

        return post(
                endpoint,
                payload,
                null,
                null);

    }

    /**
     * Executes HTTP POST request.
     */
    protected Response post(
            String endpoint,
            Object payload,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams) {

        return buildRequest(
                AuthType.NO_AUTH,
                pathParams,
                queryParams)
                .body(payload)
                .when()
                .post(endpoint);

    }

    // =========================================================================
    // PUT
    // =========================================================================

    /**
     * Executes HTTP PUT request.
     */
    protected Response put(
            String endpoint,
            Object payload,
            Map<String, ?> pathParams) {

        return put(
                endpoint,
                payload,
                pathParams,
                null);

    }

    /**
     * Executes HTTP PUT request.
     */
    protected Response put(
            String endpoint,
            Object payload,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams) {

        return buildRequest(
                AuthType.NO_AUTH,
                pathParams,
                queryParams)
                .body(payload)
                .when()
                .put(endpoint);

    }

    // =========================================================================
    // PATCH
    // =========================================================================

    /**
     * Executes HTTP PATCH request.
     */
    protected Response patch(
            String endpoint,
            Object payload,
            Map<String, ?> pathParams) {

        return patch(
                endpoint,
                payload,
                pathParams,
                null);

    }

    /**
     * Executes HTTP PATCH request.
     */
    protected Response patch(
            String endpoint,
            Object payload,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams) {

        return buildRequest(
                AuthType.NO_AUTH,
                pathParams,
                queryParams)
                .body(payload)
                .when()
                .patch(endpoint);

    }

    // =========================================================================
    // DELETE
    // =========================================================================

    /**
     * Executes HTTP DELETE request.
     */
    protected Response delete(
            String endpoint,
            Map<String, ?> pathParams) {

        return delete(
                endpoint,
                pathParams,
                null);

    }

    /**
     * Executes HTTP DELETE request.
     */
    protected Response delete(
            String endpoint,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams) {

        return buildRequest(
                AuthType.NO_AUTH,
                pathParams,
                queryParams)
                .when()
                .delete(endpoint);

    }

}