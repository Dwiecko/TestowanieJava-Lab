import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLogin {
	
	public WebDriver driver;
	private final Wait<WebDriver> wait;

	public PageObjectLogin(PhantomJSDriver driver){
		this.driver = driver;
		driver.get("http://budgetapplication20180122102533.azurewebsites.net/Account/Login");
		wait = new WebDriverWait(driver,10);
	}

	public PageObjectLogin(HtmlUnitDriver driver){
		this.driver = driver;
		driver.get("http://budgetapplication20180122102533.azurewebsites.net/Account/Login");
		wait = new WebDriverWait(driver,10);
	}
	
	public String login() throws Exception{
		driver.findElement(By.cssSelector("#Email")).sendKeys("Test@test.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("Test!23");
        driver.findElement(By.xpath("//div[5]/button")).click();
   
        return "Pomyślnie zalogowano";
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Budget Application");
		System.out.println(driver.getTitle());
		return(result);
	}
	
}