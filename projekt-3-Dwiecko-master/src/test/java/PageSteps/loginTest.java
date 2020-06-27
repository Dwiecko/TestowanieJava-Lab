package PageSteps;

import Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class loginTest {
    private static WebDriver driver = null;
    private final String URL = "http://automationpractice.com/";
    private LoginPage loginPage = null;

    @Before
    public void setBrowser() {
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
       driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^user is  on homepage$")
    public void goToSiteURL() throws Throwable {
        driver.get(URL);
    }

    @When("^user navigates to Login Page$")
    public void navigateToLoginPage() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @And("^user enters username and Password$")
    public void userEntersUsernameAndPassword() throws Throwable {
        loginPage.login("sebo@bitwhites.top", "ABCDE");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^success message is displayed$")
    public void redirectsToMyAccount() throws Throwable {
        boolean titleIsCorrect = loginPage.assertTitle();
        Assertions.assertTrue(titleIsCorrect, "Title is correct for: My account - My Store");
    }

    @And("^user enters incorrect username and Password$")
    public void userEntersIncorrectUsernameAndPassword() throws Throwable {
        loginPage.login("aaaaaaaaao@bitwhites.top", "secret");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^error message is displayed$")
    public void errorMessageIsDisplayed() throws Throwable {
        boolean titleIsCorrect = loginPage.assertTitle();

        Assertions.assertFalse(titleIsCorrect);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}