package junit_tests;

import com.kradova.core.driver.WebDriverFactory;
import com.kradova.pages.blog.BlogPage;
import com.kradova.pages.home.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

public class JunitBaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();
    protected HomePage homePage = new HomePage(driver);
    protected BlogPage blogPage = new BlogPage(driver);

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
