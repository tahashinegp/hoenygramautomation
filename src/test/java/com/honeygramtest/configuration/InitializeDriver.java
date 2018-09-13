package com.honeygramtest.configuration;

import com.honeygramtest.utilites.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class InitializeDriver {
    static Device device =new Device();
    static File file;
    static AppiumDriver<MobileElement> driver;
    static Properties prop;
    static String path;
    public static AppiumDriver getDriver() throws IOException {
        ADBcommands.getDeviceList();
        ADBcommands.processDevicelist();
        DesiredCapabilities caps = new DesiredCapabilities();
        String apk_path="";

        //Instantiate Appium Driver
        try {
            caps.setCapability(CapabilityType.PLATFORM_NAME,"Android");
            caps.setCapability("appium-version","1.8.1");
            caps.setCapability("deviceName",device.getDeviceName());
            caps.setCapability("platformVersion",device.getOsInfo());
            caps.setCapability("uuid",device.getDeviceID());
            caps.setCapability("app", apk_path=getApk());
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);


        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
        //http://www.qaautomated.com/2016/02/how-to-use-apis-to-locate-elements-and.html
    }

    public static String getApk() throws IOException {
        prop= Helper.getProperties();
        path= prop.getProperty("apk_path");
        return path;
    }

}
