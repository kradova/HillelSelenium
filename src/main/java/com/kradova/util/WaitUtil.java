package com.kradova.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.kradova.util.ConfigProvider.EXPLICIT_WAIT;

public class WaitUtil {
    private WaitUtil() {
    }

    public static WebElement waitElementIsVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitElementIsClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
