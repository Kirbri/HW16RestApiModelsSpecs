package tests;

import models.lombok.ListUsersResponseLombokModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.ListUsersSpec.listUsersRequestSpec;
import static specs.ListUsersSpec.listUsersResponseSpec;

public class ListUsersTests extends TestBase {

    /*
    1. Make request to https://reqres.in/api/users?page=2
    2. Get response { "page": 2, "per_page": 6, "total": 12 ...
    3. Check response
*/

    @Test
    void successfulLisUsersTest() {
        ListUsersResponseLombokModel response = step("Make response", () ->
                given(listUsersRequestSpec)
                        .get("?page=2")
                        .then()
                        .spec(listUsersResponseSpec)
                        .extract().as(ListUsersResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals(2, response.getPage());
            assertEquals(6, response.getPer_page());
            assertEquals(12, response.getTotal());
            assertEquals(2, response.getTotal_pages());
            assertEquals(6, response.getData().length);
            assertEquals("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
                    response.getSupport().getUrl());
            assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.",
                    response.getSupport().getText());

        });
    }
}
