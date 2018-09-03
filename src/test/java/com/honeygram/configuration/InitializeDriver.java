package com.honeygram.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitializeDriver {
    static AppiumDriver<MobileElement> driver;
    public static AppiumDriver getDriver(){
        ADBcommands.getDeviceList();
        ADBcommands.processDevicelist();
        DesiredCapabilities caps = new DesiredCapabilities();
        Device device =new Device();

        //Instantiate Appium Driver
        try {
            caps.setCapability(CapabilityType.PLATFORM_NAME,"Android");
            caps.setCapability("deviceName",device.getDeviceName());
            caps.setCapability("platformVersion",device.getOsInfo());
            caps.setCapability("uuid",device.getDeviceID());
            caps.setCapability("app", "/Users/nishant/Development/HelloAppium/app/quikr.apk");
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);


        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;

    }

}
