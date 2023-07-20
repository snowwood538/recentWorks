package constants;

import utils.ParseUtils;

import static constants.PathConstants.CONFIG_FILE_PATH;

public class CredentialConstants {
    public static final String LOGIN = ParseUtils.parseFromJson("login");
    public static final String PASSWORD = ParseUtils.parseFromJson("password");
    public static final String URL = ParseUtils.parseFromJson("URL",CONFIG_FILE_PATH);
}
