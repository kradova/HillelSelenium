package com.kradova.core.driver;

import com.kradova.core.Browser;
import com.kradova.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    public static final String BROWSER = System.getProperty("browser");

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;
        return getDriver(Browser.valueOf(browserType.toUpperCase()));
    }

    private static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFireFoxDriver();
            case EDGE:
                return getEdgeDriver();
            case IE:
                return getInternetExplorerDriver();
            default:
                System.out.println("Unknown browser");
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver getFireFoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private static WebDriver getEdgeDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }

    private static WebDriver getInternetExplorerDriver() {
        if (driver == null) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        return driver;
    }
}
