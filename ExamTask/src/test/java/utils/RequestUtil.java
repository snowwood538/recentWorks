package utils;

import static constants.AttributeConstants.CONTENT_ATTRIBUTE;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Base64;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestUtil {

    public static Response post(Map<String, ?> mapOfParams, String endpoint) {
        return RestAssured.given().log().all()
                .params(mapOfParams)
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response postImage(Map<String, ?> mapOfParams, String endpoint, byte[] imageByte) {
        return RestAssured.given().log().all()
                .params(mapOfParams)
                .params(CONTENT_ATTRIBUTE, Base64.getEncoder().encodeToString(imageByte))
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
