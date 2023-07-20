package utils;

import enums.Domains;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Constants.LOWER_KIR_CHARS;
import static constants.Constants.LOWER_LAT_CHARS;
import static constants.Constants.NUMBERS;
import static constants.Constants.UPPER_KIR_CHARS;
import static constants.Constants.UPPER_LAT_CHARS;

public class RandomGenerator {

    public static String generateRandomString(int len) {
        ArrayList<String> combination = new ArrayList<>() {{
            addAll(List.of(UPPER_LAT_CHARS, LOWER_LAT_CHARS, NUMBERS, UPPER_KIR_CHARS, LOWER_KIR_CHARS));
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

    public static String generateRandomDomain() {
        ArrayList<String> domains = new ArrayList<>() {{
            add(Domains.GMAIL.getDomain());
            add(Domains.YANDEX.getDomain());
            add(Domains.MAIL.getDomain());
        }};
        SecureRandom random = new SecureRandom();
        return domains.get(random.nextInt(domains.size()));
    }

    public static int getNumberExceptingNumbers(int range) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(range);
    }
}
