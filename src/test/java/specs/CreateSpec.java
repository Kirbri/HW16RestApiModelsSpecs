package specs;

import helpers.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class CreateSpec {
    public static RequestSpecification createRequestSpec = with()
            .filter(CustomAllureListener.withCustomTemplate())
            .log().uri()
            .log().body()
            .log().headers()
            .contentType(ContentType.JSON)
            .basePath("/api/users");

    public static ResponseSpecification createResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();
}
