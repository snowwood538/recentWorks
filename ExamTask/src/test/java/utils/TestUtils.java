package utils;

import aquality.selenium.browser.AqualityServices;
import static constants.CredentialConstants.URI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@lombok.experimental.UtilityClass
public class TestUtils {

    public static void authorisation(String login, String password) {
        String urlWithCredentials = String.format("http://%s:%s%s", login, password, URI);
        AqualityServices.getBrowser().goTo(urlWithCredentials);
    }

    public static byte[] makeScreenshot() {
        return AqualityServices.getBrowser().getScreenshot();
    }

    public static String readFile(String path) {
        String file = null;
        try {
            file = Files.readString(Paths.get(path));
        } catch (IOException e) {
            AqualityServices.getLogger().error("The file cannot be read" + e.getMessage());
        }
        return file;
    }
    public static <T> String getPath(Class<T> classToLoad, String fileName) {
        ClassLoader classLoader = classToLoad.getClassLoader();
        java.net.URL resourceUrl = classLoader.getResource(fileName);
        String absolutePath = null;
        if (resourceUrl != null) {
            java.io.File resourcesDirectory = new java.io.File(resourceUrl.getFile());
            absolutePath = resourcesDirectory.getAbsolutePath();
        }
        return absolutePath;
    }
}
