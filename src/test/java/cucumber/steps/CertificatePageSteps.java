package cucumber.steps;

import com.kradova.pages.certificate.CertificatePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CertificatePageSteps extends BaseSteps {
    private CertificatePage page;

    @Before
    public void goToPage() {
        page = new CertificatePage(driver);
        page.open();
    }

    @When("search certificate number:{int}")
    public void searchCert(int num) {
    page.checkCert(num);
    String res = page.getResult();
        Assert.assertEquals(res, "Сертифікат не знайдено");
    }
}
