package constants;

import static constants.PathConstants.CONFIG_DATA_PATH;
import utils.ParseUtils;

public class CredentialConstants {

    public static final String LOGIN = ParseUtils.parseFromJson("login");
    public static final String PASSWORD = ParseUtils.parseFromJson("password");
    public static final String URI = "@" + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"URI") + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"WEB_ENDPOINT");
    public static final String URL = ParseUtils.parseFromJson(CONFIG_DATA_PATH,"HTTP")
            + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"URI") + ParseUtils.parseFromJson(CONFIG_DATA_PATH,"WEB_ENDPOINT");
}
