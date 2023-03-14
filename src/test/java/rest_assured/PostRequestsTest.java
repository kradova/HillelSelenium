package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestsTest extends RestAssuredBase {
    @Test
    public void postUserTest() {
        String user = "{\n" +
                "    \"name\": \"Ann\",\n" +
                "    \"job\": \"QA\"\n" +
                "}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/users")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("Ann", response.jsonPath().getString("name"));
        Assertions.assertEquals("QA", response.jsonPath().getString("job"));
    }

    @Test
    public void postRegisterPassTest() {
        String user = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pass1\"\n" +
                "}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/register")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("4", response.jsonPath().getString("id"));
        Assertions.assertNotNull(response.jsonPath().getString("token"));
    }

    @Test
    public void postRegisterFailTest() {
        String user = "{\"email\": \"sydney@fife\"}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/register")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        Assertions.assertNotNull(response.jsonPath().getString("error"));
    }

    @Test
    public void postLoginTest() {
        String user = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/login")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertNotNull(response.jsonPath().getString("token"));
    }

    @Test
    public void postLoginFailTest() {
        String user = "{\"email\": \"peter@klaven\"}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/login")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        Assertions.assertEquals("Missing password", response.jsonPath().getString("error"));
    }
}
