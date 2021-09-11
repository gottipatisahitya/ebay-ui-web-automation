package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver _driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        _driver = driver;
        wait = new WebDriverWait(_driver, 30);
    }

    public void WaitUntilElementIsLocated(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void PerformClickActionOnElement(By selector) {
        WaitUntilElementIsLocated(selector);
        _driver.findElement(selector).click();
    }

}
