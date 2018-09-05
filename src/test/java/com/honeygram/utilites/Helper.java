package com.honeygram.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Helper {
    static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    static String appConfigPath = rootPath + "honeygram.properties";
    public static Properties getProperties() throws IOException {
        Properties p =new Properties();
        p.load(new FileInputStream(appConfigPath));
        return p;
    }
}
