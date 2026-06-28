package endpoints;

public final class Routes {

    private Routes() {
    }

    //=====================
    // User APIs
    //=====================

    public static final String GET_USERS = "/api/users?page={page}";

    public static final String GET_SINGLE_USER = "/api/users/{id}";

    public static final String CREATE_USER = "/api/users";

    public static final String UPDATE_USER = "/api/users/{id}";

    public static final String DELETE_USER = "/api/users/{id}";

}