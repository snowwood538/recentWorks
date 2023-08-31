package utils;

import static constants.ApiMethods.GET_TEST_LIST;
import static constants.ApiMethods.GET_TOKEN;
import static constants.ApiMethods.PUT_ATTACHMENT;
import static constants.ApiMethods.PUT_TEST;
import static constants.AttributeConstants.CONTENT_ATTRIBUTE;
import static constants.AttributeConstants.CONTENT_TYPE_ATTRIBUTE;
import static constants.AttributeConstants.ENV_ATTRIBUTE;
import static constants.AttributeConstants.METHOD_NAME_ATTRIBUTE;
import static constants.AttributeConstants.PROJECT_ID_ATTRIBUTE;
import static constants.AttributeConstants.PROJECT_NAME_ATTRIBUTE;
import static constants.AttributeConstants.SID_ATTRIBUTE;
import static constants.AttributeConstants.TEST_ID_ATTRIBUTE;
import static constants.AttributeConstants.TEST_NAME_ATTRIBUTE;
import static constants.AttributeConstants.VARIANT_ATTRIBUTE;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiUtils {

    public static String getToken(int id) {
        Map<String, String> mapOfParams = new HashMap<>();
        mapOfParams.put(VARIANT_ATTRIBUTE, String.valueOf(id));
        return RequestUtil.post(mapOfParams, GET_TOKEN).asString();
    }

    public static String getTestList(int projectId) {
        Map<String, String> mapOfParams = new HashMap<>();
        mapOfParams.put(PROJECT_ID_ATTRIBUTE, String.valueOf(projectId));
        return RequestUtil.post(mapOfParams, GET_TEST_LIST).asString();
    }

    public static String createTest(Timestamp SID, String projectName, String testName, String methodName, String env) {
        Map<String, String> mapOfParams = new HashMap<>();
        mapOfParams.put(SID_ATTRIBUTE, SID.toString());
        mapOfParams.put(PROJECT_NAME_ATTRIBUTE, projectName);
        mapOfParams.put(TEST_NAME_ATTRIBUTE, testName);
        mapOfParams.put(METHOD_NAME_ATTRIBUTE, methodName);
        mapOfParams.put(ENV_ATTRIBUTE, env);
        return RequestUtil.post(mapOfParams, PUT_TEST).asString();
    }

    public static void putLogs(String testID, String logs) {
        Map<String, String> mapOfParams = new HashMap<>();
        mapOfParams.put(TEST_ID_ATTRIBUTE, testID);
        mapOfParams.put(CONTENT_ATTRIBUTE, logs);
        RequestUtil.post(mapOfParams, constants.ApiMethods.PUT_TEST_LOGS);
    }

    public static void putAttachment(String testID, byte[] content, String contentType) {
        Map<String, String> mapOfParams = new HashMap<>();
        mapOfParams.put(TEST_ID_ATTRIBUTE, testID);
        mapOfParams.put(CONTENT_TYPE_ATTRIBUTE, contentType);
        RequestUtil.postImage(mapOfParams, PUT_ATTACHMENT, content);
    }
}
