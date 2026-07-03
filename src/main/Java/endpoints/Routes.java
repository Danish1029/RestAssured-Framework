package endpoints;

public final class Routes {

    private Routes() {
    }

    // Pet APIs
    public static final String CREATE_PET = "/pet";
    public static final String GET_PET = "/pet/{petId}";
    public static final String UPDATE_PET = "/pet";
    public static final String DELETE_PET = "/pet/{petId}";
    public static final String FIND_BY_STATUS = "/pet/findByStatus";

    // User APIs
    public static final String CREATE_USER = "/user";
    public static final String GET_USER = "/user/{username}";
    public static final String UPDATE_USER = "/user/{username}";
    public static final String DELETE_USER = "/user/{username}";
    public static final String LOGIN_USER = "/user/login";
    public static final String LOGOUT_USER = "/user/logout";

    // Store APIs
    public static final String INVENTORY = "/store/inventory";
    public static final String PLACE_ORDER = "/store/order";
    public static final String GET_ORDER = "/store/order/{orderId}";
    public static final String DELETE_ORDER = "/store/order/{orderId}";
}