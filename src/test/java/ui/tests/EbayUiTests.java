package ui.tests;

import org.junit.jupiter.api.*;
import configProviders.ConfigFileReader;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NavigationPage;
import pages.SignInPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EbayUiTests extends BaseTest {

    protected HomePage homePage;
    protected NavigationPage navigationPage;
    protected SignInPage signInPage;

    protected EbayUiTests() {
        homePage = new HomePage(driver);
        navigationPage = new NavigationPage(driver);
        signInPage = new SignInPage(driver);
    }

    @BeforeEach
    public void beforeTest() {
        driver.navigate().to(ConfigFileReader.baseUrl);
    }

    @AfterEach
    public void afterTest() {
        driver.manage().deleteAllCookies();
    }

    @DisplayName("Verify ebay logo is visible")
    @Test
    public void verifyEbayLogo() {
        WebElement ebayLogo = homePage.findEbayLogoElement();
        assertTrue(ebayLogo.isDisplayed());
    }

    @DisplayName("Verify error messages when logging in without username and password")
    @Test
    public void verifyLoggingInWithoutUsernameOrPasswordThrowsError() {
        navigationPage.clickMyEbayMenuLink();
        signInPage.clickSignInContinue();
        assertTrue(signInPage.getSignInErrorMessageText().contains("Oops, that's not a match"));
    }
}



