package com.kradova.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties props = initProperties();
    public static final String BROWSER = props.getProperty("browser");
    public static final String BASE_URL = props.getProperty("base.url");
    public static final String HILLEL_URL = props.getProperty("hillel.url");
    public static final int IMPLICIT_WAIT = Integer.parseInt(props.getProperty("implicit_wait"));
    public static final int EXPLICIT_WAIT = Integer.parseInt(props.getProperty("explicit_wait"));
    public static final int SCROLL_WAIT = Integer.parseInt(props.getProperty("scroll_wait"));

    private ConfigProvider() {
    }

    private static Properties initProperties() {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file");
        }
        return properties;
    }
}
