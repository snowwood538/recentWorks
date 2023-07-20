package constants;

import static constants.AttributeConstants.CONFIG_FILE;
import static constants.AttributeConstants.JS_SCRIPT_FILE;
import static constants.AttributeConstants.TEST_FILE;
import utils.TestUtils;

public class PathConstants {

    public static final String CONFIG_DATA_PATH = TestUtils.getPath(PathConstants.class, CONFIG_FILE);
    public static final String TEST_DATA_PATH = TestUtils.getPath(PathConstants.class, TEST_FILE);
    public static final String LOG_FILE_PATH = "target/log/log.log";
    public static final String JS_SCRIPT_PATH = TestUtils.getPath(PathConstants.class, JS_SCRIPT_FILE);
}
