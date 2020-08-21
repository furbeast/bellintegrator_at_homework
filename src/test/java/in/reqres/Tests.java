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

        System.out.println("*****************************************************************************************");
        System.out.println(userList.get("data.email").toString());
    }

    @Test
    public void testTask4_2a() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        JsonPath registrationUser = Steps.regusterUser("eve.holt@reqres.in", "pistol").jsonPath();

        System.out.println(registrationUser.get("id").toString());
        System.out.println(registrationUser.get("token").toString());
    }

    @Test
    public void testTask4_2b() {
        Specification.installSpec(Specification.requestSpec());
        JsonPath registrationUser = Steps.regusterUser("sydney@fife").jsonPath();
    }
}
