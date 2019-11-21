package dfloriani.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://dfloriani.glitch.me/";

    //Locators
    //"Go to demo form" button
    @FindBy(xpath = "//*[@test-id=\"about-goToForm-button\"]")
    private WebElement goToDemoFormButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void goToDemoForm(){
        goToDemoFormButton.click();
    }

}
