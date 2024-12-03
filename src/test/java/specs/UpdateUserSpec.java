package specs;

import helpers.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class UpdateUserSpec {
    public static RequestSpecification updateUserRequestSpec = with()
            .filter(CustomAllureListener.withCustomTemplate())
            .log().uri()
            .log().body()
            .log().headers()
            .contentType(ContentType.JSON)
            .basePath("/api/users");

    public static ResponseSpecification updateUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();
}