package utils;

import org.openqa.selenium.Cookie;

@lombok.experimental.UtilityClass
public class CookieUtils {

    public static Cookie getBasicCookie(String tokenAttribute, String token ) {
        return new Cookie(tokenAttribute, token);
    }
}
