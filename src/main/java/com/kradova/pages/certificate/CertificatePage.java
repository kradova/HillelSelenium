package com.kradova.pages.certificate;

import com.kradova.pages.base.BasePage;
import com.kradova.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CertificatePage extends BasePage {
    public static final String PAGE_URL = "https://certificate.ithillel.ua/";

    public CertificatePage(WebDriver driver) {
        super(driver, PAGE_URL);
    }

    public By certificateNumInput = By.xpath("//*[@id=\"certificateCheckForm\"]/div/input");
    public By checkCertBtn = By.xpath("//*[@id=\"certificateCheckForm\"]/div/button");
    public By resultField = By.xpath("//*[@id=\"certificateCheckForm\"]/p");

    public void checkCert(int num) {
        driver.findElement(certificateNumInput)
                .sendKeys(Integer.toString(num));
        driver.findElement(checkCertBtn)
                .click();
        WaitUtil.waitElementIsVisible(driver, driver.findElement(resultField));
    }

    public String getResult() {
        return driver.findElement(resultField).getText();
    }
}
