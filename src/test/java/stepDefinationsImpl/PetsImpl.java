package stepDefinationsImpl;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import stepDefinitions.AbstractStepDefinition;
import stepDefinitionsInterfaces.Pets;
import utlis.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PetsImpl extends AbstractStepDefinition implements Pets {

    @Override
    public  Response createPets(String createPetRequestBody) throws IOException {
        commonResponse = given().header("Content-Type","application/json").auth().preemptive().oauth2(authorization).body(createPetRequestBody).when().log().all().
                post("https://petstore.swagger.io/v2/pet").then().log().all().statusCode(200).extract().response();
        createPetResp = commonResponse;
            return commonResponse;
        }

    @Override
    public  Response updatePets(String updatePetRequestBody) throws IOException {
        commonResponse = given().header("Content-Type","application/json").auth().preemptive().oauth2(authorization).body(updatePetRequestBody).when().log().all().
                put("https://petstore.swagger.io/v2/pet").then().log().all().statusCode(200).extract().response();
        updatePetResp = commonResponse;
        return commonResponse;
    }
    @Override
    public  Response getPetsByStatus() throws IOException {
        commonResponse = given().header("Content-Type","application/json").auth().preemptive().oauth2(authorization).when().log().all().
                queryParam("status","available")
                .get("https://petstore.swagger.io/v2/pet/findByStatus").then().log().all().statusCode(200).extract().response();
        getByStatusResp = commonResponse;
        return commonResponse;
    }

    @Override
    public  Response getPetsById() throws IOException {
        commonResponse = given().header("Content-Type","application/json").auth().preemptive().oauth2(authorization).when().log().all().
                get("https://petstore.swagger.io/v2/pet/1").then().log().all().statusCode(200).extract().response();
        getPetsByIdResp = commonResponse;
        return commonResponse;
    }

    @Override
    public  Response updateStoreByFormData()  {
        commonResponse = given().header("api-key","special-key").auth().preemptive().oauth2(authorization)
                .formParam("name","kitten")
                .formParam("status","pending").
        when().log().all().
                post("https://petstore.swagger.io/v2/pet/1").then().log().all().statusCode(200).extract().response();
        updateStoreByFormDataResp = commonResponse;
        return commonResponse;
    }
    @Override
    public  Response deletePetById()  {
        commonResponse = given().header("api-key","special-key").auth().preemptive().oauth2(authorization)
                .when().log().all().
                delete("https://petstore.swagger.io/v2/pet/1").then().log().all().statusCode(200).extract().response();
        deletePetByResp = commonResponse;
        return commonResponse;
    }
    @Override
    public  Response storePetOrder(String storePetRequestBody)  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization)
                .body(storePetRequestBody).when().log().all().
                post("https://petstore.swagger.io/v2/store/order").then().log().all().statusCode(200).extract().response();
        storepetOrderResp = commonResponse;
        return commonResponse;
    }
    @Override
    public  Response getPetsByOrderId()  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization).when().log().all().
                get("https://petstore.swagger.io/v2/store/order/"+Id).then().log().all().statusCode(200).extract().response();
        petOrdersByStoreIdResp = commonResponse;
        return commonResponse;
    }

    @Override
    public  Response deletePetsByOrderId()  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization).when().log().all().
                delete("https://petstore.swagger.io/v2/store/order/"+Id).then().log().all().statusCode(200).extract().response();
        deletePetsByStoreIdResp = commonResponse;
        return commonResponse;
    }

    @Override
    public  Response getInventory()  {
        commonResponse = given().header("api-key","special-key").auth().preemptive().oauth2(authorization).when().log().all().
                get("https://petstore.swagger.io/v2/store/inventory").then().log().all().statusCode(200).extract().response();
         getInventoriesResp= commonResponse;
        return commonResponse;
    }
    @Override
    public  Response createUser(String createUserRequestBody)  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization).body(createUserRequestBody).when().log().all().
                post("https://petstore.swagger.io/v2/user").then().log().all().statusCode(200).extract().response();
        createUseresp= commonResponse;
        return commonResponse;
    }

    @Override
    public  Response getLogTheUser()  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization)
        .queryParam("username","TestPetUser")
                .queryParam("password","TestPetUser@123")
                .when().log().all().
                get("https://petstore.swagger.io/v2/user/login").then().log().all().statusCode(200).extract().response();
        getLogUserResp= commonResponse;
        return commonResponse;
    }
    @Override
    public  Response getByUserName()  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization)
                .when().log().all().
                get("https://petstore.swagger.io/v2/user/testing").then().log().all().statusCode(200).extract().response();
        getByUsernameResp= commonResponse;
        return commonResponse;
    }

    @Override
    public  Response updateExistingUser(String updateExistingRequestBody)  {
        commonResponse = given().header("Content-Type", "application/json").auth().preemptive().oauth2(authorization).body(updateExistingRequestBody).when().log().all().
                put("https://petstore.swagger.io/v2/user/testing").then().log().all().statusCode(200).extract().response();
        updateExistingUseresp= commonResponse;
        return commonResponse;
    }

    @Override
    public  Response deleteUser()  {
        commonResponse = given().header("api-key", "special-key").auth().preemptive().oauth2(authorization)
                .when().log().all().
                delete("https://petstore.swagger.io/v2/user/testing").then().log().all().statusCode(200).extract().response();
        deleteUserResp= commonResponse;
        return commonResponse;
    }

    @Override
    public  Response logoutUser() {
        commonResponse = given().header("Content-Type","application/json").auth().preemptive().oauth2(authorization).when().log().all().
                get("https://petstore.swagger.io/v2/user/logout").then().log().all().statusCode(200).extract().response();
        logouserResp = commonResponse;
        return commonResponse;
    }

}

