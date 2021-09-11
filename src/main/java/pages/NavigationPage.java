package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {

    private WebDriver _driver;
    private WebDriverWait wait;

    public NavigationPage(WebDriver driver) {
        super(driver);
        _driver = driver;
        wait = new WebDriverWait(_driver, 30);
    }

    public void clickMyEbayMenuLink() {
        WaitUntilElementIsLocated(By.cssSelector("[aria-label='Account']"));
        PerformClickActionOnElement(By.cssSelector("a[href='https://www.ebay.com.au/mys/home?source=GBH']"));
    }
}

