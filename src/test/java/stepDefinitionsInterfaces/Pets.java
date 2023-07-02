package stepDefinitionsInterfaces;

import io.restassured.response.Response;

import java.io.IOException;

public interface Pets {

    Response createPets(String createPetRequestBody) throws IOException;
    Response updatePets(String updateRequestBody) throws IOException;
    Response getPetsByStatus() throws IOException;
    Response getPetsById() throws IOException;
    Response updateStoreByFormData();
    Response deletePetById();
    Response storePetOrder(String storePetRequestBody);
    Response getPetsByOrderId() throws IOException;
    Response deletePetsByOrderId() throws IOException;
    Response getInventory();
    Response createUser(String createUserRequestBody);
    Response getLogTheUser();
    Response getByUserName();
    Response updateExistingUser(String updateExistingUserRequestBody) throws IOException;
    Response deleteUser();
    Response logoutUser();




}
