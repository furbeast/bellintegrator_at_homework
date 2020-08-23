package in.reqres;

import io.restassured.path.json.JsonPath;
//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;  // с этим в Allure как-то эстетичнее

import java.util.List;
import java.util.stream.Collectors;

public class Tests {

    @Test
    public void testTask4_1() {
//        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        Specification.installSpec(Specification.requestSpec());
        JsonPath userList = Steps.getUsersList().jsonPath();
        Steps.matchAvatars(userList);
    }

    @Test
    public void testTask4_2a() {
//        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        Specification.installSpec(Specification.requestSpec());
        Steps.registerUser("eve.holt@reqres.in", "pistol");
    }

    @Test
    public void testTask4_2b() {
        Specification.installSpec(Specification.requestSpec());
        Steps.registerUser("sydney@fife");
    }

    @Test
    public void testTask4_3() {
//        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec());
        Specification.installSpec(Specification.requestSpec());
        JsonPath getList = Steps.getList().jsonPath();
        Steps.checkList(getList);
    }
}
