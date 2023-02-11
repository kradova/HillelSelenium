import com.kradova.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();
}
