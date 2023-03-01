package cucumber.steps;

import com.kradova.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseSteps {
   protected final WebDriver driver = WebDriverFactory.getDriver();
}
