package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static constants.AttributeConstants.RESPONSE_ATTRIBUTE;


public class ResponseParser {

    public static <T> T parseJsonObject(String json, Class<T> modelClass) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject responseArray = jsonObject.getAsJsonObject(RESPONSE_ATTRIBUTE);
            return gson.fromJson(responseArray.toString(), modelClass);
    }

    public static <T> T parseJsonArray(String json, Class<T> modelClass) {
            Gson gson = new Gson();
            JsonElement jsonElement = com.google.gson.JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray responseArray = jsonObject.getAsJsonArray(RESPONSE_ATTRIBUTE);
            return gson.fromJson(responseArray.toString(), modelClass);
    }
}