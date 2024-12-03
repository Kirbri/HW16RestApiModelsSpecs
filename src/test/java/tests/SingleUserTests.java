package tests;

import models.lombok.SingleUserResponseLombokModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.GeneralSpec.*;

@Tag("HW16")
public class SingleUserTests extends TestBase {
 /*
    1. Make request to https://reqres.in/api/users/{0, 1, 2, !}
    2. Get response { "data": { "id": 2, "email": "janet.weaver@reqres.in", "first_name": "Janet" ...
    3. Check response
*/

    @Test
    void successfulSingleUser0Test() {
        SingleUserResponseLombokModel response = step("Make response", () ->
                given(requestSpecification)
                        .get("/users/0")
                        .then()
                        .spec(responseNotFoundSpecification404)
                        .extract().as(SingleUserResponseLombokModel.class));
    }

    @Test
    void successfulSingleUser1Test() {
        SingleUserResponseLombokModel response = step("Make response", () ->
                given(requestSpecification)
                        .get("/users/1")
                        .then()
                        .spec(responseSpecification200)
                        .extract().as(SingleUserResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals(1, response.getData().getId());
            assertEquals("george.bluth@reqres.in", response.getData().getEmail());
            assertEquals("George", response.getData().getFirst_name());
            assertEquals("Bluth", response.getData().getLast_name());
            assertEquals("https://reqres.in/img/faces/1-image.jpg", response.getData().getAvatar());
            assertEquals("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
                    response.getSupport().getUrl());
            assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.",
                    response.getSupport().getText());
        });
    }

    @Test
    void successfulSingleUser2Test() {
        SingleUserResponseLombokModel response = step("Make response", () ->
                given(requestSpecification)
                        .get("/users/2")
                        .then()
                        .spec(responseSpecification200)
                        .extract().as(SingleUserResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals(2, response.getData().getId());
            assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
            assertEquals("Janet", response.getData().getFirst_name());
            assertEquals("Weaver", response.getData().getLast_name());
            assertEquals("https://reqres.in/img/faces/2-image.jpg", response.getData().getAvatar());
            assertEquals("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
                    response.getSupport().getUrl());
            assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.",
                    response.getSupport().getText());
        });
    }

    @Test
    void successfulSingleUserNotNumTest() {
        SingleUserResponseLombokModel response = step("Make response", () ->
                given(requestSpecification)
                        .get("/users/!")
                        .then()
                        .spec(responseNotFoundSpecification404)
                        .extract().as(SingleUserResponseLombokModel.class));
    }
}