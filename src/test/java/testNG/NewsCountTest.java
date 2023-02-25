package testNG;

import com.kradova.pages.blog.BlogPage;
import com.kradova.pages.publications.PublicationsPage;
import com.kradova.util.WaitUtil;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Log4j2
public class NewsCountTest extends TestNgBaseTest {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
//                {BlogPage.FRONT_END_THEME, 121, "Front-end"},
//                {BlogPage.QA_THEME, 87, "QA"},
                {BlogPage.GAME_DEV_THEME, 5, "GameDev"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void testAmountOfArticles(String themeName, int expectedArticles, String name) {
        blogPage.open();
        WebElement theme = blogPage.getThemeByName(themeName);
        WaitUtil.waitElementIsVisible(driver, theme);
        theme.click();
        WaitUtil.scrollPageBottom(driver);
        List<WebElement> articles = driver.findElements(PublicationsPage.article);
        Assert.assertEquals(expectedArticles, articles.size());
    }

    @Test(testName = "Error Test")
    public void testWithError() {
        Assert.assertEquals(1, 2);
    }
}
