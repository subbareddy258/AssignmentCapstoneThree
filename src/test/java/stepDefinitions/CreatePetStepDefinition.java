package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import stepDefinationsImpl.PetsImpl;
import utlis.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class CreatePetStepDefinition extends AbstractStepDefinition{
    PetsImpl petsImpl = new PetsImpl();
    SoftAssert softAssert = new SoftAssert();

    @And("Create a {string}")
    public void createA(String scenario) throws IOException {
        petsRequestBody = Utils.parseJSONFile("src/test/resources/testing/testingbook.json").getJSONObject(scenario).toString();
        petsImpl.createPets(petsRequestBody);

    }

    @Given("Token genrated")
    public void tokenGenrated() throws IOException {
        authorization = given().header("api-key","special-key").auth().preemptive().basic("test","abc123")
                .queryParam("client_id",Utils.getPropertyData("clientId"))
                .post("https://petstore.swagger.io/oauth/authorize.ReadWrite")
                .then()
                .log().all()
                .extract().response().asString();

    }


    @When("I update the {string}")
    public void iUpdateThe(String scenario) throws IOException {
        Id =   createPetResp.jsonPath().getInt("id");
        name =   createPetResp.jsonPath().getString("name");
        status = createPetResp.jsonPath().getString("status");
        updatepetsRequestBody = Utils.parseJSONFile("src/test/resources/testing/testingbook.json").getJSONObject(scenario).toString();
        petsImpl.updatePets(updatepetsRequestBody);
        softAssert.assertEquals(1,Id);
       softAssert.assertNotEquals("rabbit",name);
       softAssert.assertAll();
    }

    @Then("I get pet by status")
    public void iGetPetByStatus() throws IOException {
        petsImpl.getPetsByStatus();
    }

    @And("I get pet by Id")
    public void iGetPetById() throws IOException {
        petsImpl.getPetsById();
      Assert.assertEquals(getPetsByIdResp.jsonPath().getInt("id"),updatePetResp.jsonPath().getInt("id"));
        Assert.assertEquals(getPetsByIdResp.jsonPath().getString("name"),updatePetResp.jsonPath().getString("name"));
        Assert.assertEquals(getPetsByIdResp.jsonPath().getString("status"),updatePetResp.jsonPath().getString("status"));
    }

    @Then("update pet form data")
    public void updatePetFormData() {
        petsImpl.updateStoreByFormData();
    }

    @And("Delete pet from store")
    public void deletePetFromStore() {
        petsImpl.deletePetById();
        Assert.assertEquals(deletePetByResp.jsonPath().getInt("code"),200);
        Assert.assertEquals(deletePetByResp.jsonPath().getString("message"),"1");

    }

    @And("Create a store {string}")
    public void createAStore(String scenario) throws IOException {
        storePetRequestBody = Utils.parseJSONFile("src/test/resources/testing/testingbook.json").getJSONObject(scenario).toString();
        petsImpl.storePetOrder(storePetRequestBody);
                Assert.assertEquals(storepetOrderResp.jsonPath().getInt("petId"),1);
        Assert.assertEquals(storepetOrderResp.jsonPath().getInt("quantity"),1);
        Assert.assertEquals(storepetOrderResp.jsonPath().getString("status"),"placed");
        Id = storepetOrderResp.jsonPath().getInt("id");
    }

    @When("I find pet by orderId")
    public void iFindPetByOrderId() {
        petsImpl.getPetsByOrderId();
        Assert.assertEquals(storepetOrderResp.jsonPath().getInt("petId"),petOrdersByStoreIdResp.jsonPath().getInt("petId"));
        Assert.assertEquals(storepetOrderResp.jsonPath().getInt("quantity"),petOrdersByStoreIdResp.jsonPath().getInt("quantity"));
        Assert.assertEquals(storepetOrderResp.jsonPath().getString("status"),petOrdersByStoreIdResp.jsonPath().getString("status"));


    }

    @Then("Delete purchase order by Id")
    public void deletePurchaseOrderById() {
        petsImpl.deletePetsByOrderId();
        Assert.assertEquals(deletePetsByStoreIdResp.jsonPath().getInt("code"),200);
        Assert.assertEquals(deletePetsByStoreIdResp.jsonPath().getString("message"),"1");

    }

    @And("Return the inventory order")
    public void returnTheInventoryOrder() {
        petsImpl.getInventory();
    }

    @And("Create a new {string}")
    public void createANew(String scenario) throws IOException {
        createUserRequestBody = Utils.parseJSONFile("src/test/resources/testing/testingbook.json").getJSONObject(scenario).toString();
        petsImpl.createUser(createUserRequestBody);

Assert.assertEquals(createUseresp.jsonPath().getInt("code"),200);
        Assert.assertEquals(createUseresp.jsonPath().getInt("message"),2);

    }

    @Then("user login into store")
    public void userLoginIntoStore() {
        petsImpl.getLogTheUser();
    }

    @Then("get by userName")
    public void getByUserName() {
        petsImpl.getByUserName();
        Assert.assertEquals(getByUsernameResp.jsonPath().getInt("id"),2);
        Assert.assertEquals(getByUsernameResp.jsonPath().getString("username"),"testing");
        Assert.assertEquals(getByUsernameResp.jsonPath().getString("email"),"testers@gmail.com");

    }
    @And("Update the {string}")
    public void updateThe(String scenario) throws IOException {
        updateExistimgUserRequestBody = Utils.parseJSONFile("src/test/resources/testing/testingbook.json").getJSONObject(scenario).toString();
        petsImpl.updateExistingUser(updateExistimgUserRequestBody);

    }

    @Then("delete the user and logout from the system")
    public void deleteTheUserAndLogoutFromTheSystem() {
        petsImpl.deleteUser();
        petsImpl.logoutUser();
        Assert.assertEquals(logouserResp.jsonPath().getInt("code"),200);
        Assert.assertEquals(logouserResp.jsonPath().getString("message"),"ok");
    }
}
