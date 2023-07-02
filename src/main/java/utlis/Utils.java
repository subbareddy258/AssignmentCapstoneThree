package utlis;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class Utils {
    static Properties prop = new Properties();


    public static JSONObject parseJSONFile(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);

    }


    public static String getPropertyData(String getData) throws IOException {
           File   path = new File(new File("src/main/java/config/test.properties").getAbsolutePath());
        FileInputStream in = new FileInputStream(path);
        prop.load(in);
        return prop.getProperty(getData);
    }



}