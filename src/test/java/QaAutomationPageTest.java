import org.testng.Assert;

public class QaAutomationPageTest extends BaseTest {
    private static final String expectedTitle = "Курс QA Automation";
    private static final double expectedRate = 4.9;

    public static void checkCourseTitle() {
        qaAutomationPage.open();
        String title = qaAutomationPage.getCourseTitle();
        Assert.assertEquals(title, expectedTitle);
    }

    public static void checkCourseRate() {
        qaAutomationPage.open();
        double rate = qaAutomationPage.getCourseRate();
        Assert.assertEquals(rate, expectedRate);
        qaAutomationPage.close();
    }
}
