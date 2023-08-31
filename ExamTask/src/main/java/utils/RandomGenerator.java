package utils;

import utils.constants.GeneratedStrings;
import static utils.constants.SymbolConstants.EMPTY_STRING;

public class RandomGenerator {

    public static String generateRandomString(int len) {
        java.util.ArrayList<String> combination = new java.util.ArrayList<>() {{
            add(GeneratedStrings.UPPER_LAT_CHARS.getGeneratedStrings());
            add(GeneratedStrings.LOWER_LAT_CHARS.getGeneratedStrings());
            add(GeneratedStrings.NUMBERS.getGeneratedStrings());
        }};
        StringBuilder string = new StringBuilder();
        while (string.length() < len) {
            java.util.Collections.shuffle(combination);
            for (String comb : combination) {
                String[] split = comb.split(EMPTY_STRING);
                int i = (int) (Math.random() * comb.length());
                string.append(split[i]);
            }
        }
        return string.toString();
    }
    public static Integer generateRandomNumber(int range) {
        java.security.SecureRandom random = new java.security.SecureRandom();
        return random.nextInt(range);
    }
}
