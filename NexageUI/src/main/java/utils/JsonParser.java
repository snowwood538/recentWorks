package utils;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonParser {

    public static <T> T parseJsonToClass(String json, Class<T> modelClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, modelClass);
    }
}
