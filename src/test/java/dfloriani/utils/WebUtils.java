package dfloriani.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebUtils {

    final static int WAIT_TIME_OUT = 30;
    private WebDriver driver;

    public WebUtils(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean doesElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isElementEmpty(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.getAttribute("value").isEmpty();
    }

    public static void clearAndSendKeys(WebElement element, String s) {
        element.click();
        element.clear();
        element.sendKeys(s);
    }

    public static void selectCheckboxes(WebDriver driver, List<WebElement> le) {
        for (WebElement e: le) {
            if(!e.isSelected())
                e.click();
        }
    }
}
