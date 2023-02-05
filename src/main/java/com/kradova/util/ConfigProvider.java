package com.kradova.util;

import com.kradova.core.Browser;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties props = initProperties();

    public static final String BROWSER = props.getProperty("browser");
    public static final String BASE_URL = props.getProperty("base.url");


    private ConfigProvider() {}

    private static Properties initProperties()  {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file");
        }
        return properties;
    }
}
