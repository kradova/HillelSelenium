package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequestsTest extends RestAssuredBase {
    @Test
    public void getAllUsersTest() {
        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .param("page", 2)
                .when().get("/api/users")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("2", response.jsonPath().getString("total_pages"));
        Assertions.assertEquals("lindsay.ferguson@reqres.in", response.jsonPath().getString("data[1].email"));
    }

    @Test
    public void getSingleUserTest() {
        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .when().get("/api/users/2")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Janet", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Weaver", response.jsonPath().getString("data.last_name"));
    }

    @Test
    public void getSingleResourceTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when().get("/api/unknown/2")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("fuchsia rose", response.jsonPath().getString("data.name"));
        Assertions.assertEquals("2001", response.jsonPath().getString("data.year"));
    }
}
