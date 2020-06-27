import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.SeleniumExtension;
@ExtendWith(SeleniumExtension.class)
public class ExpectedConditionTest{
    public PhantomJSDriver driver;
    private Wait<WebDriver> wait;
    
    public ExpectedConditionTest(PhantomJSDriver driver){
        this.driver = driver;
        driver.get("http://budgetapplication20180122102533.azurewebsites.net/Account/Login");
    }

    @Test
    public void elementIsClickable(){
        WebElement loginButton = (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]/button")));
        
        assertNotNull(loginButton);
    }

    @Test
    public void elementIsAvailable(){
        WebElement loginButton = (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[5]/button")));
        
        assertNotNull(loginButton);
    }

    @Test
    public void titleContainsGivenText(){
        boolean partOfTitleIsPresent = (new WebDriverWait(driver, 3)).until(ExpectedConditions.titleContains("Budget"));
        
        assertTrue(partOfTitleIsPresent);
    }

    @Test
    public void logInTextIsPresentInLogInButton(){
        boolean logInTextIsPresent = (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElement(By.xpath("//div[5]/button"), "Log in"));
        
        assertTrue(logInTextIsPresent);
    }

    @Test
    public void textIsPresentInElementValue(){
        WebElement email = driver.findElement(By.cssSelector("#Email"));
        String userEmail = "email@email.com";
        email.sendKeys(userEmail);

        boolean isPresent = (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("#Email"), userEmail));
        assertTrue(isPresent);
    }

    // @Test
    // public void elementIsSelected(){
    //     driver.findElement(By.cssSelector("#Email")).click();

    //     boolean isSelected = (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeSelected(By.cssSelector("#Email")));
        
    //     assertTrue(isSelected);
    // }
}