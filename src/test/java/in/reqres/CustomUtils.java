package in.reqres;

import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomUtils {

    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".json")
    public static byte[] getJson(JsonPath jsonText) {
        try {
            FileUtils.write(new File("src/main/resources/in_reqres/error.json"), jsonText.prettify());
            return Files.readAllBytes(Paths.get("src/main/resources/in_reqres","error.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
