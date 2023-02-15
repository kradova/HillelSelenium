package com.kradova.util;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.kradova.util.ConfigProvider.EXPLICIT_WAIT;

public class Wrapper {

    public static boolean isElementClickable(WebDriver driver, WebElement element) {
        boolean res;
        try {
            new WebDriverWait(driver, EXPLICIT_WAIT)
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            // return false if element isn't Clickable
            // in other case app crashes with a Timeout Exception
            return false;
        }
    }

    public static void clickAfterWaiting(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static boolean isElNotExistAfterClick(WebDriver driver, WebElement element, By elementLocator) {
        element.click();
        try {
            new WebDriverWait(driver, EXPLICIT_WAIT)
                    .until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
            return true;
        } catch (TimeoutException e) {
            // return false if element doesn't disappear
            // in other case app crashes with a Timeout Exception
            return false;
        }
    }
}
