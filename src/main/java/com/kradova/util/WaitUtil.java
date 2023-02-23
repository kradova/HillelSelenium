package com.kradova.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.kradova.util.ConfigProvider.EXPLICIT_WAIT;
import static com.kradova.util.ConfigProvider.SCROLL_WAIT;

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

    public static void scrollPageBottom(WebDriver driver) {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long startHeight = 0;
        while (true) {
            long currentHeight = (Long) js.executeScript("return document.body.scrollHeight");
            if (startHeight == currentHeight) {
                break;
            }
            actions.pause(SCROLL_WAIT);
            actions.sendKeys(Keys.END).perform();
            startHeight = currentHeight;
        }
    }
}
