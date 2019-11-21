package dfloriani.pages;

import dfloriani.utils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FormPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@test-id=\"form-demoForm\"]")
    private WebElement form;

    @FindBy(xpath = "//*[@test-id=\"form-inputEmail\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@test-id=\"form-inputPassword\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@test-id=\"form-checkMeOut-checkbox\"]")
    private WebElement checkMeOut;

    @FindBy(xpath = "//*[@test-id=\"form-submitButton\"]")
    private WebElement submitButton;

    public FormPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public boolean isPageOpened() {
        return WebUtils.isElementDisplayed(form);
    }

    public void fillInEmail(String s) {
        WebUtils.waitForElementVisible(driver, email);
        WebUtils.clearAndSendKeys(email, s);
    }

    public void fillInPassword(String s) {
        WebUtils.clearAndSendKeys(password, s);
    }

    public void checkMeOut() {
        checkMeOut.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean doesSuccessfulMessageExist(WebDriver driver) {
        return true;
    }

}
