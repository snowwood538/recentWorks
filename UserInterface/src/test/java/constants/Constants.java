package constants;

import utils.ParseUtils;

import java.util.Objects;

public class Constants {
    public static final String CONFIG_FILE_PATH = "src/test/resources/ConfigData.json";
    public static final String TEST_FILE_PATH ="src/test/resources/testData.json";
    public static final String SCRIPT_PATH ="src/test/resources/AutoItScript.exe";
    public static final Integer NUMBER_DROPDOWN_DOMAINS = Integer.parseInt(Objects.requireNonNull(ParseUtils.parseFromJson("NUMBER_DROPDOWN_DOMAINS")));
    public static final Long  WAITER = Long.parseLong(ParseUtils.parseFromJson("WAITER"));
    public static final Integer PASSWORD_LENGTH =Integer.parseInt(Objects.requireNonNull(ParseUtils.parseFromJson("PASSWORD_LENGTH")));
    public static final Integer REQUIRED_NUMBER_CHECKBOX =Integer.parseInt(Objects.requireNonNull(ParseUtils.parseFromJson("REQUIRED_NUMBER_CHECKBOX")));
    public static final String EXPECTED_TIME = ParseUtils.parseFromJson("EXPECTED_TIME");
    public static final String UPPER_LAT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_LAT_CHARS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String UPPER_KIR_CHARS = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    public static final String LOWER_KIR_CHARS = "йцукенгшщзхфывапролджэъюбьтимсчя";
}
