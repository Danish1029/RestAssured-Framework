package auth;

import io.restassured.specification.RequestSpecification;

public final class AuthFactory {

    private AuthFactory() {
    }

    public static RequestSpecification applyAuthentication(
            RequestSpecification requestSpec,
            AuthType authType,
            String... credentials) {

        switch (authType) {

        case NO_AUTH:
            return requestSpec;

        case BASIC:
            return requestSpec.auth()
                    .preemptive()
                    .basic(credentials[0], credentials[1]);

        case BEARER:
            return requestSpec.auth()
                    .oauth2(credentials[0]);

        case API_KEY:
            return requestSpec.header("x-api-key", credentials[0]);

        case JWT:
            return requestSpec.header("Authorization",
                    "Bearer " + credentials[0]);

        case OAUTH2:
            return requestSpec.auth()
                    .oauth2(credentials[0]);

        default:
            throw new IllegalArgumentException(
                    "Unsupported Authentication Type");

        }

    }

}