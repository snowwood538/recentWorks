package constants;

import static constants.PathConstants.CONFIG_DATA_PATH;
import utils.ParseUtils;
import utils.RandomGenerator;

public class AttributeConstants {

    public static final String URI = ParseUtils.parseFromJson(CONFIG_DATA_PATH,"HTTP")
            + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"URI") + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"API_ENDPOINT");
    public static final int NEXAGE_PROJECT_ID = 1;
    public static final int VARIANT_ID = 2;
    public static final String TOKEN_ATTRIBUTE = "token";
    public static final int EXPECTED_VARIANT = 2;
    public static final int ORIGINAL_TAB_INDEX = 0;
    public static final String PROJECT_NAME = RandomGenerator.generateRandomString(10);
    public static final String TEST_NAME = ParseUtils.parseFromJson("test_name");
    public static final String METHOD_NAME = ParseUtils.parseFromJson("method_name");
    public static final String ENV = ParseUtils.parseFromJson("env");
    public static final String CONTENT_TYPE = ParseUtils.parseFromJson("content_type");
    public static final String VARIANT_ATTRIBUTE = "variant";
    public static final String SPAN_ATTRIBUTE = "/span";
    public static final String SRC_ATTRIBUTE = "src";
    public static final String TEST_FIELD_ATTRIBUTE = "//td[%d]";
    public static final String TEST_CLASS_A_ATTRIBUTE = "/a";
    public static final String CONFIG_FILE = "configFile.json";
    public static final String TEST_FILE = "testData.json";
    public static final String JS_SCRIPT_FILE = "closePopup.js";
    public static final String PHOTO_ENCODER_ATTRIBUTE = "data:image/png;base64,";
    public static final String PROJECT_ID_ATTRIBUTE = "projectId";
    public static final String SID_ATTRIBUTE = "SID";
    public static final String PROJECT_NAME_ATTRIBUTE = "projectName";
    public static final String TEST_NAME_ATTRIBUTE = "testName";
    public static final String METHOD_NAME_ATTRIBUTE = "methodName";
    public static final String ENV_ATTRIBUTE = "env";
    public static final String TEST_ID_ATTRIBUTE = "testId";
    public static final String CONTENT_ATTRIBUTE = "content";
    public static final String CONTENT_TYPE_ATTRIBUTE = "contentType";
}
