package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.io.File;
import java.util.Map;

import static constants.ApiConstants.ACCESS_TOKEN_PARAM;
import static constants.ApiConstants.OWNER_ID;
import static constants.ApiConstants.VERSION;
import static constants.ApiConstants.VERSION_NUMBER;
import static constants.PathConstants.CONFIG_FILE_PATH;


public class ResponseUtils {

    public static final String USER_ID = ParseUtils.parseFromJson("user_id");
    private static final String ACCESS_TOKEN = ParseUtils.parseFromJson("ACCESS_TOKEN", CONFIG_FILE_PATH);

    public static Map<String, String> baseRequestParams() {
        return Map.of(ACCESS_TOKEN_PARAM, ACCESS_TOKEN,
                OWNER_ID, USER_ID,
                VERSION, VERSION_NUMBER);
    }

    public static ValidatableResponse post(Map<String, ?> mapOfParams, String path) {
        RestAssured.basePath = path;
        return RestAssured.given().log().all().params(mapOfParams).post().then().log().all();
    }

    public static ValidatableResponse post(Map<String, ?> mapOfParams, String path, String typeOfFile, String fileValue) {
        RestAssured.basePath = path;
        return RestAssured.given().log().all().params(mapOfParams).multiPart(typeOfFile, fileValue).post().then().log().all();
    }

    public static ValidatableResponse get(Map<String, ?> mapOfParams, String path) {
        RestAssured.basePath = path;
        return RestAssured.given().log().all().params(mapOfParams).post().then().log().all();
    }

    public static ValidatableResponse upload(Map<String, ?> mapOfParams, String path, String fileTType, String pathToFile, String conversionType) {
        return RestAssured.given().log().all().multiPart(fileTType, new File(pathToFile), conversionType).params(mapOfParams).post(path).then().log().all();
    }
}
