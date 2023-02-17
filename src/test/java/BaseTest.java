import com.kradova.core.driver.WebDriverFactory;
import com.kradova.pages.home.HomePage;
import com.kradova.pages.qa_automation.QaAutomationPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();
    protected static HomePage homePage = new HomePage(driver);
    protected static QaAutomationPage qaAutomationPage = new QaAutomationPage(driver);
    public static void closeBrowser() {
        driver.quit();
    }
}
