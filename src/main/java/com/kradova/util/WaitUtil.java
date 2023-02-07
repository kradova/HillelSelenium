package com.kradova.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.kradova.util.ConfigProvider.EXPLICIT_WAIT;

public class WaitUtil {
    private WaitUtil() {
    }

    public static void waitElementIsVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
