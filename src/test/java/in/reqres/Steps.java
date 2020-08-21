package in.reqres;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Steps {

    @Step("Шаг 1. Получить список пользователей со второй страницы")
    public static Response getUsersList() {
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
//                .log().all()
                .extract().response();
        return response;
    }

    @Step("Шаг 2. Убедится что аватары пользователей совпадают")
    public static void tst1() {

    }

    @Step("Шаг 1. Протестировать регистрацию пользователя в системе OK")
    public static Response regusterUser(String email, String password) {
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
                .extract().response();

        return response;
    }

    @Step("Шаг 1. Протестировать регистрацию пользователя в системе Error")
    public static Response regusterUser(String email) {
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
}
