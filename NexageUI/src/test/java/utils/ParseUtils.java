package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static constants.PathConstants.TEST_DATA_PATH;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@lombok.experimental.UtilityClass
public class ParseUtils {

    public static String parseFromJson(String param) {
        return parseFromJson(TEST_DATA_PATH, param);
    }

    public static String parseFromJson(String path, String param) {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(new File(path));
        } catch (IOException e) {
            aquality.selenium.browser.AqualityServices.getLogger().error("cannot parse from file" + e.getMessage());
        }

        Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
        String fieldText = null;
        while (fieldsIterator.hasNext()) {
            Map.Entry<String,JsonNode> field = fieldsIterator.next();
            if (field.getKey().equals(param)){
                fieldText = field.getValue().asText();
            }
        }
        return Objects.requireNonNull(fieldText, "fieldText is empty");
    }
}
