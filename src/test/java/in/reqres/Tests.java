package in.reqres;

import io.restassured.path.json.JsonPath;
//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;  // с этим в Allure как-то эстетичнее

public class Tests {

    @Test
    public void testTask4_1() {
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        JsonPath userList = Steps.getUsersList().jsonPath();
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
