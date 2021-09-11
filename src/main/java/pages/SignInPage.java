package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignInPage extends BasePage{

    private WebDriver _driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        super(driver);
        _driver = driver;
        wait = new WebDriverWait(_driver, 30);
    }

    public void clickSignInContinue() {
        WaitUntilElementIsLocated(By.name("signin-form"));
        _driver.findElement(By.name("signin-continue-btn")).click();
    }

    public String getSignInErrorMessageText() {
        List<WebElement> errorMessagesList = _driver.findElements(By.cssSelector("#signin-error-msg #errormsg"));
        String errorMessage = (errorMessagesList.size() > 0)
                ? _driver.findElement(By.cssSelector("#signin-error-msg #errormsg")).getText() : null;
        return errorMessage;
    }
}
