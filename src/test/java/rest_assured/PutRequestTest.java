package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRequestTest extends RestAssuredBase {
    @Test
    public void updateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().put("/api/users/2")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("morpheus", response.jsonPath().getString("name"));
        Assertions.assertEquals("zion resident", response.jsonPath().getString("job"));
        Assertions.assertNotNull(response.jsonPath().getString("updatedAt"));
    }
}
