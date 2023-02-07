import com.kradova.core.driver.WebDriverFactory;
import com.kradova.util.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class MyFirstTest extends BaseTest {
    public static void myTest() {
        driver.get(ConfigProvider.BASE_URL);
        driver.quit();
    }
}
