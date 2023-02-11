import com.kradova.core.driver.WebDriverFactory;
import com.kradova.util.ConfigProvider;
import com.kradova.util.WaitUtil;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HillelPageTest extends BaseTest {
    private static final By btnAQACourse = By.xpath("//a[@href=\"https://ithillel.ua/courses/testing\"]");
    private static final By pageHeader = By.className("hero-title");
    private static final String textInHeader = "Курси тестування у Києві";

    public static void isTextExist() {
        driver.get(ConfigProvider.HILLEL_URL);
        driver.findElement(btnAQACourse).click();
        WebElement header = driver.findElement(pageHeader);
        WaitUtil.waitElementIsVisible(driver, header);
        Assert.assertEquals(header.getText(), textInHeader);
        driver.quit();
    }
}
