package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static constants.PathConstants.TEST_FILE_PATH;

public class ParseUtils {
    public static String parseFromJson(String param) {
        return parseFromJson(param, TEST_FILE_PATH);
    }

    public static String parseFromJson(String param, String path) {
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
