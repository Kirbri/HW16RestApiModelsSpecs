package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.GeneralSpec.requestSpecification;
import static specs.GeneralSpec.responseSpecification204;

@Tag("HW16")
public class DeleteTests extends TestBase {

    /*
1. Make request (DELETE) to https://reqres.in/api/users{2, _, 19021}
2. Check response code
*/

    @Test
    void successfulDelete2Test() {
        step("Make response", () ->
                given(requestSpecification)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(responseSpecification204));
    }

    @Test
    void successfulDeleteTest() {
        step("Make response", () ->
                given(requestSpecification)
                        .when()
                        .delete("/users")
                        .then()
                        .spec(responseSpecification204));
    }

    @Test
    void successfulDelete19021Test() {
        step("Make response", () ->
                given(requestSpecification)
                        .when()
                        .delete("/users/19021")
                        .then()
                        .spec(responseSpecification204));
    }
}