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

    public Response getPetById(long petId) {

        Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("petId", petId);

        return get(Routes.GET_PET, pathParams);

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
    
    

}