package com.kradova.core.driver;

import com.kradova.core.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                //@TODO
                break;
            case FIREFOX:
                //@TODO
                break;
            case EDGE:
                //@TODO
                break;
            case IE:
                //@TODO
                break;
            default:
                System.out.println("Unknown browser");
        }
        return driver;
    }//getDriver()

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver getInternetExplorerDriver() {
        return new InternetExplorerDriver();
    }
}//WebDriverFactory
