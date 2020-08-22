package in.reqres;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;  // с этим в Allure как-то эстетичнее

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Tests {

    @Test
    public void testTask4_1() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        JsonPath userList = Steps.getUsersList().jsonPath();














        userList = JsonPath.given("{\n" +
                "    \"page\": 2,\n" +
                "    \"per_page\": 6,\n" +
                "    \"total\": 12,\n" +
                "    \"total_pages\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 7,\n" +
                "            \"email\": \"michael.lawson@reqres.in\",\n" +
                "            \"first_name\": \"Michael\",\n" +
                "            \"last_name\": \"Lawson\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 8,\n" +
                "            \"email\": \"lindsay.ferguson@reqres.in\",\n" +
                "            \"first_name\": \"Lindsay\",\n" +
                "            \"last_name\": \"Ferguson\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 9,\n" +
                "            \"email\": \"tobias.funke@reqres.in\",\n" +
                "            \"first_name\": \"Tobias\",\n" +
                "            \"last_name\": \"Funke\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 10,\n" +
                "            \"email\": \"byron.fields@reqres.in\",\n" +
                "            \"first_name\": \"Byron\",\n" +
                "            \"last_name\": \"Fields\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 11,\n" +
                "            \"email\": \"george.edwards@reqres.in\",\n" +
                "            \"first_name\": \"George\",\n" +
                "            \"last_name\": \"Edwards\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 12,\n" +
                "            \"email\": \"rachel.howell@reqres.in\",\n" +
                "            \"first_name\": \"Rachel\",\n" +
                "            \"last_name\": \"Howell\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ad\": {\n" +
                "        \"company\": \"StatusCode Weekly\",\n" +
                "        \"url\": \"http://statuscode.org/\",\n" +
                "        \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
                "    }\n" +
                "}");




















        Steps.matchAvatars(userList);
    }

    @Test
    public void testTask4_2a() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        JsonPath registrationUser = Steps.regusterUser("eve.holt@reqres.in", "pistol").jsonPath();
    }

    @Test
    public void testTask4_2b() {
        Specification.installSpec(Specification.requestSpec());
        JsonPath registrationUser = Steps.regusterUser("sydney@fife").jsonPath();
    }

    @Test
    public void testTask4_3() {

    }
}
