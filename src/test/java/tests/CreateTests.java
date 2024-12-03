package tests;

import models.lombok.CreateBodyLombokModel;
import models.lombok.CreateResponseLombokModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.CreateSpec.createRequestSpec;
import static specs.CreateSpec.createResponseSpec;

public class CreateTests extends TestBase {

    /*
1. Make request (POST) to https://reqres.in/api/users/{2sq, 0, 1, 2, !}
with body { "name": "morpheus", "job": "leader" }
2. Get response { "name": "morpheus", "job": "leader" ...
3. Check response
*/

    @Test
    void successfulCreateTest() {
        CreateBodyLombokModel authData = new CreateBodyLombokModel();
        authData.setName("Morpheus");
        authData.setJob("Leader");

        CreateResponseLombokModel response = step("Make request", () ->
                given(createRequestSpec)
                        .body(authData)
                        .when()
                        .post()
                        .then()
                        .spec(createResponseSpec)
                        .extract().as(CreateResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals("Morpheus", response.getName());
            assertEquals("Leader", response.getJob());
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }

    @Test
    void successfulCreateNoDataTest() {
        CreateBodyLombokModel authData = new CreateBodyLombokModel();

        CreateResponseLombokModel response = step("Make request", () ->
                given(createRequestSpec)
                        .body(authData)
                        .when()
                        .post()
                        .then()
                        .spec(createResponseSpec)
                        .extract().as(CreateResponseLombokModel.class));

        step("Check response", () -> {
            assertNull(response.getName());
            assertNull(response.getJob());
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }
}
