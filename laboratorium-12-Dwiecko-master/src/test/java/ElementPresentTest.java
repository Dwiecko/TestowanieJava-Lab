import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class ElementPresentTest{
    public WebDriver driver;
	private final Wait<WebDriver> wait;

	public ElementPresentTest(FirefoxDriver driver){
		this.driver = driver;
		driver.get("http://budgetapplication20180122102533.azurewebsites.net/Account/Login");
		wait = new WebDriverWait(driver,10);
	}
    
    @Test
    public void elementExistsOnPage(){
        boolean isOnPage = isElementPresent(By.cssSelector("#Email"));
        assertTrue(isOnPage);
    }

    @Test
    public void elementDoesNotExistsOnPage(){
        boolean isOnPage = isElementPresent(By.cssSelector("#Emailzzzzzzzz"));
        assertFalse(isOnPage);
    }

    private boolean isElementPresent(By by){
        try{
         driver.findElement(by);
            
            return true;
        }
        catch(ElementNotFoundException ex){return false;}
        catch(Exception ex){return false;}
    }
}