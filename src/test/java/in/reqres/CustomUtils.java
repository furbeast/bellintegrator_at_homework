package in.reqres;

import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomUtils {
    /*@Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    public static byte[] getJson(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }*/




    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    public static byte[] getJson(String resourceName) {
        try {
            return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }




/*    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    public static byte[] getJson(JsonPath jsonPath) {
        File json = new File()

        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/ru.yandex.market/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources/ru.yandex.market","screen.png"));




            return Files.readAllBytes(Paths.get("src/main/resources/in.reqres", "Хуй"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];



//        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
//        return Files.readAllBytes(Paths.get(jsonPath.get().toString()));*/
//    }
}
