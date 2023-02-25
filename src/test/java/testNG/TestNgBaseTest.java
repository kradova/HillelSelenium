package testNG;

import com.kradova.core.driver.WebDriverFactory;
import com.kradova.pages.blog.BlogPage;
import com.kradova.pages.home.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@Log4j2
public class TestNgBaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();
    protected HomePage homePage = new HomePage(driver);
    protected BlogPage blogPage = new BlogPage(driver);

    @BeforeMethod
    public void testStartedLog(Method method) {
        log.info(String.format("Test %s started", method.getName()));
    }

    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            log.info(String.format("Test %s finished with result SUCCESS", result.getName()));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            log.info(String.format("Test %s finished with result FAILED", result.getName()));
        }
    }

    @AfterSuite
    public static void afterAll() {
        driver.quit();
    }
}
