package utils;

import io.restassured.response.ValidatableResponse;
import models.response.VkInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static constants.ApiConstants.ATTACHMENTS;
import static constants.ApiConstants.CONVERSION_TYPE;
import static constants.ApiConstants.HASH;
import static constants.ApiConstants.MESSAGE;
import static constants.ApiConstants.PHOTO;
import static constants.ApiConstants.PHOTO_PATH;
import static constants.ApiConstants.POSTS;
import static constants.ApiConstants.POST_ID;
import static constants.ApiConstants.SERVER;
import static constants.VKApiMethods.GET_WALL_UPLOAD_SERVER;
import static constants.VKApiMethods.SAVE_WALL_PHOTO;
import static constants.VKApiMethods.WALL_CREATE_COMMENT;
import static constants.VKApiMethods.WALL_DELETE;
import static constants.VKApiMethods.WALL_EDIT;
import static constants.VKApiMethods.WALL_GET_BY_ID;
import static constants.VKApiMethods.WALL_POST;
import static utils.ResponseUtils.baseRequestParams;

public class ApiUtils {

    public static VkInfo postPost(String message) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(MESSAGE, message);
        String response = ResponseUtils.post(requestParams, WALL_POST).extract().body().asString();
        return ResponseParser.parseJsonObject(response, VkInfo.class);
    }

    public static VkInfo[] getId(String ownerId, int postId) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(POSTS, ownerId + "_" + postId);
        String response = ResponseUtils.get(requestParams, WALL_GET_BY_ID).extract().body().asString();
        return ResponseParser.parseJsonArray(response, VkInfo[].class);
    }

    public static VkInfo[] getId2(String ownerId, int postId) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(POSTS,ownerId + "_" + postId);
        String validatableResponse = ResponseUtils.get(requestParams, WALL_GET_BY_ID).extract().body().asString();
        return ResponseParser.parseJsonArray(validatableResponse, VkInfo[].class);
    }


    public static ValidatableResponse getUploadServer() {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        return ResponseUtils.get(requestParams, GET_WALL_UPLOAD_SERVER);
    }


    public static VkInfo[] savePhoto(HashMap<String, String> photoFromServer) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(SERVER, photoFromServer.get(SERVER));
        requestParams.put(HASH, photoFromServer.get(HASH));
        String response = ResponseUtils.post(requestParams, SAVE_WALL_PHOTO, PHOTO, photoFromServer.get(PHOTO)).extract().asString();
        return ResponseParser.parseJsonArray(response, VkInfo[].class);
    }

    public static HashMap<String, String> getPhotoInfoFromServer(String url) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        String photoInfo = ResponseUtils.upload(requestParams, url, PHOTO, PHOTO_PATH, CONVERSION_TYPE).extract().body().asString();
        HashMap<String, String> mapPhotoInfo = new HashMap<>();
        mapPhotoInfo.put(PHOTO, StringUtils.substringBetween(photoInfo, "photo\":\"", "\",\"hash").replace("\\", "")) ;
        mapPhotoInfo.put(HASH, StringUtils.substringBetween(photoInfo, "]\",\"hash\":\"", "\"}"));
        mapPhotoInfo.put(SERVER, StringUtils.substringBetween(photoInfo, "\"server\":", ",\"photo\""));
        return mapPhotoInfo;
    }

    public static VkInfo updatePost(String ownerId, String postId, String message, String photoId) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(MESSAGE, message);
        requestParams.put(ATTACHMENTS, PHOTO + ownerId + "_" + photoId);
        requestParams.put(POST_ID, postId);
        String response = ResponseUtils.post(requestParams, WALL_EDIT).extract().body().asString();
        return ResponseParser.parseJsonObject(response, VkInfo.class);
    }

    public static void addComment(String postId, String message ) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(MESSAGE, message);
        requestParams.put(POST_ID, postId);
        ResponseUtils.post(requestParams, WALL_CREATE_COMMENT);
    }

    public static void deletePost(String postId) {
        Map<String, String> requestParams = new HashMap<>(baseRequestParams());
        requestParams.put(POST_ID, postId);
        ResponseUtils.post(requestParams, WALL_DELETE);
    }

}
