package com.kradova.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public String pageUrl;

    public BasePage(WebDriver driver, String pageUrl) {
        this.driver = driver;
        this.pageUrl = pageUrl;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void open() {
        open(pageUrl);
    }

    public void close() {
        driver.quit();
    }
}
