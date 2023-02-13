package com.kradova.pages.qa_automation;

import com.kradova.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QaAutomationPage extends BasePage {

    private static final String pageUrl = "https://ithillel.ua/courses/qa-automation";
    private static final By courseTitle = By.className("course-descriptor_header-text");
    private static final By courseRate = By.xpath("//span[@class='course-rating_average']");
    public static final By pageLogo = By.xpath("//a[@class='site-logo-link']");

    public QaAutomationPage(WebDriver driver) {
        super(driver);
        this.url = pageUrl;
    }

    public String getCourseTitle() {
        return driver.findElement(courseTitle).getText();
    }

    public double getCourseRate() {
        return Double.parseDouble(driver.findElement(courseRate).getText());
    }

    public WebElement getPageLogoEl() {
        return driver.findElement(pageLogo);
    }
}
