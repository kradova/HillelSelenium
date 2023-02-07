import com.kradova.core.driver.WebDriverFactory;
import com.kradova.util.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class MyFirstTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        driver.quit();
    }
}
