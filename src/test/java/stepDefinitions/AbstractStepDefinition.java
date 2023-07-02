package stepDefinitions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class AbstractStepDefinition {
    //Request intilizaation to call
    public static int Id;
    public static  String name,status;

    public static  String authorization,petsRequestBody,updatepetsRequestBody,storePetRequestBody,createUserRequestBody,updateExistimgUserRequestBody;
    //Response
    public static Response commonResponse;
    public static Response createPetResp,updatePetResp,getByStatusResp,getPetsByIdResp,updateStoreByFormDataResp,getLogUserResp,logouserResp,
            deletePetByResp,storepetOrderResp,petOrdersByStoreIdResp,deletePetsByStoreIdResp,getInventoriesResp,createUseresp,getByUsernameResp,updateExistingUseresp,deleteUserResp;
   }
