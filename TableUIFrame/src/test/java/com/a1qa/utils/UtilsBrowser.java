package com.a1qa.utils;

public class UtilsBrowser {
    public static void switchTabFrom(String originalWindow) {
        for (String windowHandle: DriveManager.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriveManager.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getCurrentWindowName(){
        String originalWindow = DriveManager.getDriver().getWindowHandle();
        assert DriveManager.getDriver().getWindowHandles().size()==1;
        return originalWindow;
    }
}
