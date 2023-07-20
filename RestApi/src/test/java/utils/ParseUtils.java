package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import static constants.Constants.TEST_DATA_PATH;

public class ParseUtils {



    public static <T> T parseFromJson(String path, Class<T> classToParse) {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        try {
             object = objectMapper.readValue(new File(path), classToParse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static String getTestConfig(String param) {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(new File(TEST_DATA_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String,JsonNode> field = fieldsIterator.next();
            if (field.getKey().equals(param) ){
                return field.getValue().asText();
            }
        }
        return null;
    }
    public static String getTestConfig(String path ,String param) {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String,JsonNode> field = fieldsIterator.next();
            if (field.getKey().equals(param) ){
                return field.getValue().asText();
            }
        }
        return null;
    }
}
