package tests;

import models.lombok.NameJobUserBodyLombokModel;
import models.lombok.CreateResponseLombokModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.GeneralSpec.requestSpecification;
import static specs.GeneralSpec.responseSpecification201;

@Tag("HW16")
public class CreateTests extends TestBase {

    /*
1. Make request (POST) to https://reqres.in/api/users/{2sq, 0, 1, 2, !}
with body { "name": "morpheus", "job": "leader" }
2. Get response { "name": "morpheus", "job": "leader" ...
3. Check response
*/

    @Test
    void successfulCreateTest() {
        NameJobUserBodyLombokModel authData = new NameJobUserBodyLombokModel();
        authData.setName("Morpheus");
        authData.setJob("Leader");

        CreateResponseLombokModel response = step("Make request", () ->
                given(requestSpecification)
                        .body(authData)
                        .when()
                        .post("/users")
                        .then()
                        .spec(responseSpecification201)
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
        NameJobUserBodyLombokModel authData = new NameJobUserBodyLombokModel();

        CreateResponseLombokModel response = step("Make request", () ->
                given(requestSpecification)
                        .body(authData)
                        .when()
                        .post("/users")
                        .then()
                        .spec(responseSpecification201)
                        .extract().as(CreateResponseLombokModel.class));

        step("Check response", () -> {
            assertNull(response.getName());
            assertNull(response.getJob());
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }
}