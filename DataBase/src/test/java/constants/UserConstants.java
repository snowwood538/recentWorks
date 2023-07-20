package constants;

import utils.ParseUtils;

import java.util.Objects;

public class UserConstants {
    public static final Integer USER_ID = Integer.parseInt(Objects.requireNonNull(ParseUtils.getTestConfig("USER_ID")));
    public static final String EXPECTED_ID = ParseUtils.getTestConfig("EXPECTED_ID");
    public static final String EXPECTED_USER_ID = ParseUtils.getTestConfig("EXPECTED_USER_ID");
    public static final String USERS = ParseUtils.getTestConfig("USERS");
    public static final String GET_USER_ID = ParseUtils.getTestConfig("GET_USER_ID");
}
