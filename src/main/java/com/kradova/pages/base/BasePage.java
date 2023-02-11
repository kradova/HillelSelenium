package com.kradova.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void open() {
        open(url);
    }

    public void close() {
        driver.quit();
    }
}
