package utils;

import enums.GeneratedStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomGenerator {

    public static String generateRandomString(int len) {
        ArrayList<String> combination = new ArrayList<>() {{
            addAll(List.of(GeneratedStrings.LOWER_LAT_CHARS.getGeneratedStrings(), GeneratedStrings.UPPER_LAT_CHARS.getGeneratedStrings()));
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
