package api;

import java.util.HashMap;
import java.util.Map;

import base.BaseAPI;
import endpoints.Routes;
import io.restassured.response.Response;
import models.Pet;

public class PetAPI extends BaseAPI {

    public Response createPet(Pet pet) {

        return post(Routes.CREATE_PET, pet);
                
    }
    
    public Response createPetWithoutBody() {

        return post(Routes.CREATE_PET, null);

    }

    public Response getPetById(long petId) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("petId", petId);

        return get(Routes.GET_PET, pathParams,pathParams);

    }

    public Response updatePet(Pet pet) {

        return put(Routes.UPDATE_PET, pet, Map.of());

    }

    public Response deletePet(long petId) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("petId", petId);

        return delete(Routes.DELETE_PET, pathParams);

    }

    public Response findPetsByStatus(String status) {

        return get(Routes.FIND_BY_STATUS + "?status=" + status);

    }
    
    /**
     * Retrieves all pets matching the supplied status.
     *
     * Example:
     * GET /pet/findByStatus?status=available
     *
     * @param status Status of the pets.
     *               Supported values:
     *               available
     *               pending
     *               sold
     *
     * @return REST Assured Response object.
     */
    public Response getPetsByStatus(String status) {

        // Stores query parameters.
        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("status", status);

        // Path parameters are not required for this API,
        // therefore we pass null.
        return get(
                Routes.FIND_PET_BY_STATUS,
                null,
                queryParams);

    }

}