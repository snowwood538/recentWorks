package constants;

import utils.ParseUtils;
import utils.RandomGenerator;

import java.util.Objects;

public class Constants {
    public static final String DOMAIN = "DOMAIN";
    public static final Integer EXPECTED_LENGTH = Integer.valueOf(Objects.requireNonNull(ParseUtils.getTestConfig("EXPECTED_LENGTH")));
    public static final Integer LENGTH_OF_GENERATION = Integer.parseInt(Objects.requireNonNull(ParseUtils.getTestConfig("LENGTH_OF_GENERATION")));
    public static final String POSTS = ParseUtils.getTestConfig("POSTS");
    public static final String EXPECTED_POST_NOT_FOUND_ID = ParseUtils.getTestConfig("EXPECTED_POST_NOT_FOUND_ID");
    public static final int PROJECT_ID = 5;
    public static final int SESSION_ID = 12;


}
