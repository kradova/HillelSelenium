package com.kradova.util;

import com.kradova.pages.qa_automation.QaAutomationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.kradova.util.ConfigProvider.EXPLICIT_WAIT;

public class Wrapper {

    public static boolean isElementClickable(WebDriver driver, WebElement element) {
        boolean res = false;
        try {
            new WebDriverWait(driver, EXPLICIT_WAIT)
                    .until(ExpectedConditions.elementToBeClickable(element));
            res = true;
        } catch (Exception e) {
            System.out.println("Element is not clickable");
        }
        return res;
    }

    public static void clickAfterWaiting(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static boolean isElNotExistAfterClick(WebDriver driver, WebElement element) {
        element.click();
        WebElement res = null;
        try {
            res = driver.findElement(QaAutomationPage.pageLogo);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return res == null;
    }
}
