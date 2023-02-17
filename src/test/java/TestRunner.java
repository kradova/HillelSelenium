import com.kradova.pages.qa_automation.QaAutomationPage;

public class TestRunner {
    public static void main(String[] args) {
        //MyFirstTest.myTest();

        //HillelPageTest.isTextExist();

        //QaAutomationPageTest.checkCourseTitle();
        //QaAutomationPageTest.checkCourseRate();

        WrapperClassTest.testClickAfterWaiting();
        WrapperClassTest.testIsLogoDisappearsAfterClick();
        WrapperClassTest.testIsElementClickable();

        BaseTest.closeBrowser();
    }
}
