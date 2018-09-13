package com.honeygramtest.utilites;

import com.honeygram.utils.Users;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Helper {
    static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    static String appConfigPath = rootPath + "honeygram.properties";
    static AndroidDriver driver;
    static Properties p=new Properties();

    public static Properties getProperties() throws IOException {
        //p=new Properties();
        p.load(new FileInputStream(appConfigPath));
        return p;
    }

    public Helper(){}


    // Create and return a New Page
    public  static <TPage>TPage getPage(Class<TPage> pageClass) {
       //AppiumFieldDecorator afd = new AppiumFieldDecorator(driver, MAX_WAIT_FOR_ELEMENT_SEC, TimeUnit.SECONDS);
        return PageFactory.initElements(driver,pageClass);

    }
    //get username
    /*public HashMap<String,String> getUser(){
        HashMap<String,String> map =new HashMap();
        String userName=p.getProperty("username");
        String pass=p.getProperty("pass");
        map.put("username",userName);
        map.put("pass",pass);
        return map;
    }*/
    //get user name and password from properties file
    public Users getUser() {
        //HashMap<String, String> map = new HashMap();
        Users user=new Users();
        String userName = p.getProperty("username");
        String pass = p.getProperty("pass");
        user.setUserName(userName);
        user.setPass(pass);
        return user;
    }
}
