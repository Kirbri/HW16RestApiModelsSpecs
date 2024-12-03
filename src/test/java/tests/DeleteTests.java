package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.DeleteSpec.deleteRequestSpec;
import static specs.DeleteSpec.deleteResponseSpec;

public class DeleteTests extends TestBase {

    /*
1. Make request (DELETE) to https://reqres.in/api/users{2, _, 19021}
2. Check response code
*/

    @Test
    void successfulDelete2Test() {
        step("Make response", () ->
                given(deleteRequestSpec)
                        .when()
                        .delete("/2")
                        .then()
                        .spec(deleteResponseSpec));
    }

    @Test
    void successfulDeleteTest() {
        step("Make response", () ->
                given(deleteRequestSpec)
                        .when()
                        .delete()
                        .then()
                        .spec(deleteResponseSpec));
    }

    @Test
    void successfulDelete19021Test() {
        step("Make response", () ->
                given(deleteRequestSpec)
                        .when()
                        .delete("/19021")
                        .then()
                        .spec(deleteResponseSpec));
    }
}
