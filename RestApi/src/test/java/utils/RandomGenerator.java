package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constants.Constants.LOWER_LAT_CHARS;
import static constants.Constants.UPPER_LAT_CHARS;

public class RandomGenerator {
    public static String generateRandomString(int len) {
        ArrayList<String> combination = new ArrayList<>() {{
            addAll(List.of(UPPER_LAT_CHARS, LOWER_LAT_CHARS));
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
}
