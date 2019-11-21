package dfloriani.tests;

import dfloriani.pages.FormPage;
import dfloriani.pages.HomePage;
import dfloriani.utils.GenerateData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoFormTest {

    private WebDriver driver;
    private GenerateData genData;
    private HomePage homePage;
    private FormPage formPage;

    @BeforeMethod
    public void setup() {
        // Use Chrome driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genData = new GenerateData();
        homePage = new HomePage(driver);
        homePage.goToDemoForm();
        formPage = new FormPage(driver);
    }

    @Test
    public void defaultStateTest() {
        Assert.assertTrue(formPage.isPageOpened());
        // Verify form fields have empty values by default
    }

    @Test
    public void successfulRegistrationTest() throws InterruptedException {
        Assert.assertTrue(formPage.isPageOpened());
        // Submitting a valid form should present successful confirmation message
        String email = genData.generateEmail(30);
        formPage.fillInEmail(email);

        String password = genData.generateStringWithAllowedSplChars(20, "!\"£$%^&*())");
        formPage.fillInPassword(password);

        formPage.checkMeOut();
        formPage.clickSubmit();
        // Check that successful message is presented
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
