package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private WebDriver _driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        _driver = driver;
        wait = new WebDriverWait(_driver, 30);
    }

    public WebElement findEbayLogoElement() {
        By selector = By.cssSelector("#gh-logo");
        WaitUntilElementIsLocated(selector);
        WebElement ebayLogo = _driver.findElement(selector);
        return ebayLogo;
    }
}
