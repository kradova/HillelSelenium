import com.kradova.core.driver.WebDriverFactory;
import com.kradova.pages.qa_automation.QaAutomationPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();
    protected static QaAutomationPage qaAutomationPage = new QaAutomationPage(driver);
}
