package utils;

import enums.GeneratedStrings;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class RandomGenerator {

    public static String generateRandomString(int len) {
        ArrayList<String> combination = new ArrayList<>() {{
                add(GeneratedStrings.UPPER_LAT_CHARS.getGeneratedStrings());
                add(GeneratedStrings.LOWER_LAT_CHARS.getGeneratedStrings());
                add(GeneratedStrings.NUMBERS.getGeneratedStrings());
        }};
        StringBuilder string = new StringBuilder();
        while (string.length() < len) {
            Collections.shuffle(combination);
            for (String comb : combination) {
                String[] split = comb.split("");
                int i = (int) (Math.random() * comb.length());
                string.append(split[i]);
            }
        }
        return string.toString();
    }
    public static Integer generateRandomNumber(int range) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(range);
    }
}
