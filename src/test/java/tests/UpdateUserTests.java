package tests;

import models.lombok.NameJobUserBodyLombokModel;
import models.lombok.UpdateUserResponseLombokModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.GeneralSpec.requestSpecification;
import static specs.GeneralSpec.responseSpecification200;

@Tag("HW16")
public class UpdateUserTests extends TestBase {
 /*
    1. Make request (PUT) to https://reqres.in/api/users/{2sq, 0, 1, 2, !}
    2. Get response { "data": { "id": 2, "email": "janet.weaver@reqres.in", "first_name": "Janet" ...
    3. Check response
*/

    @Test
    void successfulUpdateUser2sqTest() {
        NameJobUserBodyLombokModel authData = new NameJobUserBodyLombokModel();
        authData.setName("NAME_test1");
        authData.setJob("JOB_test1");

        UpdateUserResponseLombokModel response = step("Make request", () ->
                given(requestSpecification)
                        .body(authData)
                        .when()
                        .put("/users/2sq")
                        .then()
                        .spec(responseSpecification200)
                        .extract().as(UpdateUserResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals("NAME_test1", response.getName());
            assertEquals("JOB_test1", response.getJob());
            assertNotNull(response.getUpdatedAt());
        });
    }

    @Test
    void successfulUpdateUser0Test() {
        NameJobUserBodyLombokModel authData = new NameJobUserBodyLombokModel();
        authData.setName("name test2");
        authData.setJob("job test2");

        UpdateUserResponseLombokModel response = step("Make request", () ->
                given(requestSpecification)
                        .body(authData)
                        .when()
                        .put("/users/0")
                        .then()
                        .spec(responseSpecification200)
                        .extract().as(UpdateUserResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals("name test2", response.getName());
            assertEquals("job test2", response.getJob());
            assertNotNull(response.getUpdatedAt());
        });
    }

    @Test
    void successfulUpdateUser1Test() {
        NameJobUserBodyLombokModel authData = new NameJobUserBodyLombokModel();
        authData.setName("NaMe test3");
        authData.setJob("JoB test3");

        UpdateUserResponseLombokModel response = step("Make request", () ->
                given(requestSpecification)
                        .body(authData)
                        .when()
                        .put("/users/1")
                        .then()
                        .spec(responseSpecification200)
                        .extract().as(UpdateUserResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals("NaMe test3", response.getName());
            assertEquals("JoB test3", response.getJob());
            assertNotNull(response.getUpdatedAt());
        });
    }
}