package com.honeygram.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class UIhelper {
    static AndroidDriver  driver;
    //Click Method
    public static void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public static void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public static String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
