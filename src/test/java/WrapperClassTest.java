import com.kradova.util.Wrapper;
import org.testng.Assert;

public class WrapperClassTest extends BaseTest {
    private static final String expectedUrl = "https://ithillel.ua/courses/testing";

    public static void testClickAfterWaiting() {
        homePage.open();
        Wrapper.clickAfterWaiting(driver, homePage.getQACourseBtn());
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public static void testIsLogoDisappearsAfterClick() {
        qaAutomationPage.open();
        boolean res = Wrapper.isElNotExistAfterClick(driver, qaAutomationPage.getPageLogoEl());
        Assert.assertTrue(res);
    }

    public static void testIsElementClickable() {
        boolean res = Wrapper.isElementClickable(driver, homePage.getQACourseBtn());
        Assert.assertTrue(res);
    }
}
