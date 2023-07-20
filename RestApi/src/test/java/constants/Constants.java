package constants;

import utils.ParseUtils;

import java.util.Objects;

public class Constants {

    public static final String CONFIG_DATA_PATH = "src/test/resources/ConfigData.json";
    public static final String USERS_JSON_PATH= "src/test/resources/user.json";
    public static final String TEST_DATA_PATH = "src/test/resources/testData.json";
    public static final String DOMAIN = "DOMAIN";
    public static final Integer POST_USER_ID = Integer.parseInt(Objects.requireNonNull(ParseUtils.getTestConfig("POST_USER_ID")));
    public static final Integer EXPECTED_LENGTH = Integer.valueOf(Objects.requireNonNull(ParseUtils.getTestConfig("EXPECTED_LENGTH")));
    public static final Integer LENGTH_OF_GENERATION = Integer.parseInt(Objects.requireNonNull(ParseUtils.getTestConfig("LENGTH_OF_GENERATION")));
    public static final Integer USER_ID = Integer.parseInt(Objects.requireNonNull(ParseUtils.getTestConfig("USER_ID")));
    public static final String POSTS = ParseUtils.getTestConfig("POSTS");
    public static final String EXPECTED_ID = ParseUtils.getTestConfig("EXPECTED_ID");
    public static final String EXPECTED_USER_ID = ParseUtils.getTestConfig("EXPECTED_USER_ID");
    public static final String EXPECTED_POST_NOT_FOUND_ID = ParseUtils.getTestConfig("EXPECTED_POST_NOT_FOUND_ID");
    public static final String USERS = ParseUtils.getTestConfig("USERS");
    public static final String GET_USER_ID = ParseUtils.getTestConfig("GET_USER_ID");
    public static final String UPPER_LAT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_LAT_CHARS = "abcdefghijklmnopqrstuvwxyz";

}
