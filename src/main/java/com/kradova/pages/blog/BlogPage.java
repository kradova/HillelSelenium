package com.kradova.pages.blog;

import com.kradova.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlogPage extends BasePage {
    private static final String PAGE_URL = "https://blog.ithillel.ua/";
    public static final String FRONT_END_THEME = "Front-end";
    public static final String GAME_DEV_THEME = "GameDev";
    public static final String QA_THEME = "Тестування";

    private final List<WebElement> themes = new ArrayList<>();

    public BlogPage(WebDriver driver) {
        super(driver, PAGE_URL);
        PageFactory.initElements(driver, this);
        populateThemesList();
    }

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[2]/div/div/ul/li[1]/a")
    public WebElement frontEnd;

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[2]/div/div/ul/li[5]/a")
    public WebElement gameDev;

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[2]/div/div/ul/li[9]/a")
    public WebElement qa;

    private void populateThemesList() {
        themes.add(frontEnd);
        themes.add(gameDev);
        themes.add(qa);
    }

    public WebElement getThemeByName(String themeName) {
        for (WebElement theme : themes) {
            if (theme.getText().equals(themeName)) {
                return theme;
            }
        }
        return null;
    }
}
