package rest_assured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class RestAssuredBase {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
}
