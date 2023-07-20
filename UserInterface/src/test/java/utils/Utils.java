package utils;

import java.io.IOException;

import static constants.Constants.SCRIPT_PATH;

public class Utils {

    public static void uploadImage()  {
        try {
            Runtime.getRuntime().exec(SCRIPT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
