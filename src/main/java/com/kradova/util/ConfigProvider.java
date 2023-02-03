package com.kradova.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    public static final String CONFIG_PATH = "config.properties";

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
