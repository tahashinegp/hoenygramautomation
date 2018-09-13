package com.honeygram.screens;


import com.honeygram.utils.Users;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LogInScreen {
    AndroidDriver driver;
    AppiumFieldDecorator loginDecorator;
    @AndroidFindBy(xpath = "//[@text='Username or email']")
    public AndroidElement userIdelement;
    @AndroidFindBy(xpath = "//[@text='Password']")
    public AndroidElement passElement;
    @AndroidFindBy(xpath = "//[@text='Login']")
    public AndroidElement loginButton;

    public AndroidElement logOutbutton;
    Users user = new Users();
    public LogInScreen(AndroidDriver driver){
        driver=this.driver;
        loginDecorator=new AppiumFieldDecorator(driver);
    }

    //Enter userName
    public void enterUsername(){
        String userName=user.getUserName();

    }


}
