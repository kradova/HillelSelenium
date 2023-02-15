package com.kradova.pages.home;

import com.kradova.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final String pageUrl = "https://ithillel.ua/";
    public static final By btnAQACourse = By.xpath("//a[@href=\"https://ithillel.ua/courses/testing\"]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.url = pageUrl;
    }

    public WebElement getQACourseBtn() {
        return driver.findElement(btnAQACourse);
    }
}
