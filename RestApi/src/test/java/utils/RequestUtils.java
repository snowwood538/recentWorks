package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestUtils {

    public static Response post(String endPoint ,Object body) {
        return RestAssured.given().body(body).log().all()
                .when()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response get(String endPoint) {
        return RestAssured.given()
                .log().all()
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract().response();
    }
}
