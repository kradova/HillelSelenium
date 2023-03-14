package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequestTest extends RestAssuredBase{
    @Test
    public void deleteRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/users/2")
                .then()
                .extract().response();

        Assertions.assertEquals(204, response.statusCode());
    }
}
