package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchRequestTest extends RestAssuredBase {
    @Test
    public void patchUserNewJob() {
        String requestBody = "{\"job\": \"new job\"}";

        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().patch("/api/users/2")
                .then().log().body()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("new job", response.jsonPath().getString("job"));
    }
}
