package PageSteps;

import Pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class searchTest {
    private HomePage homePage = null;
    private WebDriver driver;

    @Before
    public void setBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefoxdriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("user is on homepage")
    public void goToSiteURL() {
        driver.get("http://automationpractice.com/");
    }

    @When("^user navigates to searchbar$")
    public void userNavigatesToSearchbar() {
        homePage.navigateToSearchBar();
    }

    @And("^user enters data not available on page$")
    public void userEntersDataNotAvailableOnPage() {
        homePage.sendTextToWebElement(homePage.SearchBar, "PRZYKLADOWY TEKST");
        homePage.SearchBar.sendKeys(Keys.RETURN);
    }

    @Then("^fail message is displayed$")
    public void failMessageIsDisplayed() {
        Assertions.assertEquals("0 results have been found.", homePage.ResultsText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
