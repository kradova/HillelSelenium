package com.kradova.pages.publications;

import com.kradova.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicationsPage extends BasePage {
    private static final String PAGE_URL = "https://blog.ithillel.ua/publications";

    public PublicationsPage(WebDriver driver) {
        super(driver, PAGE_URL);
    }

    public static final By article = By.xpath("//*[@id=\"body\"]/div[1]/main/section[2]/div/div/ul/li");
}
