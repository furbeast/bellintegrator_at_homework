package in.reqres;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.tika.io.FilenameUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Steps {

    // testTask4_1
    @Step("Шаг 1. Получить список пользователей со второй страницы")
    public static Response getUsersList() {
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
//                .log().all()
                .body("page", equalTo(2))
                .body("data.id.", notNullValue())
                .body("data.email.", notNullValue())
                .body("data.first_name.", notNullValue())
                .body("data.last_name.", notNullValue())
                .body("data.avatar.", notNullValue())
                .statusCode(200)
                .extract().response();
        return response;
    }

    @Step("Шаг 2. Убедится что аватары пользователей совпадают")
    public static void matchAvatars(JsonPath jsonPath) {
        List<String> listAvatar = new ArrayList();

        jsonPath.getList("data.avatar").stream().forEach(x -> listAvatar.add(FilenameUtils.getName((String) x)));

        for (int i = 1; i < listAvatar.size(); i++) {
            if (listAvatar.get(i).equals(listAvatar.get(0))) {
                Assert.assertTrue(true);
            } else {
                CustomUtils.getJson(jsonPath);
                Assert.fail("Аватары пользователей различны");
            }
        }
    }


    // testTask4_2
    @Step("Шаг 1. Регистрация пользователя в системе")
    public static Response registerUser(String email, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        data.put("password", password);

        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("/api/register")
                .then()
//                .log().all()
                .body("id", notNullValue())
                .body("token", notNullValue())
                .statusCode(200)
                .extract().response();

        return response;
    }

    @Step("Шаг 1. Регистрация пользователя в системе - Ошибка")
    public static Response registerUser(String email) {
        Map<String, String> data = new HashMap<>();
        data.put("email", email);

        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("/api/register")
                .then()
//                .log().all()
                .body("error", equalTo("Missing password"))
                .statusCode(400)
                .extract().response();

        return response;
    }

    @Step("Шаг 1. Получить LIST")
    public static Response getList() {
        Response response = given()
                .when()
                .get("/api/unknown")
                .then()
//                .log().all()
                .body("data.id", notNullValue())
                .body("data.name", notNullValue())
                .body("data.year", notNullValue())
                .body("data.color", notNullValue())
                .statusCode(200)
                .extract().response();
        return response;
    }

    @Step("Шаг 2. Убедится что данные отсортированные по годам")
    public static void checkList(JsonPath jsonPath) {
        List<String> listYear = jsonPath.getList("data.year");

        if (listYear.stream().sorted().collect(Collectors.toList()).equals(listYear)) {
            Assert.assertTrue(true);
        } else {
            CustomUtils.getJson(jsonPath);
            Assert.fail("Данные не отсортированны по годам");
        }
    }
}
