package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static WebDriver driver;
    private final String URL = "http://automationpractice.com";
    private Wait<WebDriver> wait;

    @CacheLookup
    @FindBy(linkText = "Sign In")
    public WebElement SignIn;

    @CacheLookup
    @FindBy(id = "search_query_top")
    public WebElement SearchBar;

    @CacheLookup
    @FindBy(css = "#center_column > h1 > span")
    public WebElement ResultsText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void sendTextToWebElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public void navigateToSearchBar(){
        SearchBar.click();
    }

    public boolean textIsPresentInErrorText(String text){
        boolean isPresent = (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(ResultsText, text));
        return  isPresent;
    }

    public void navigateToHomePage(){
        driver.get(URL);
    }
}
