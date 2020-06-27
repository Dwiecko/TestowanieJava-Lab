package pageObjectDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFindByGoogle {
   
	public WebDriver driver;
   
	@FindBy(id = "lst-ib")
	private WebElement submitMe;
	
	@FindBy(name = "q")
	private WebElement searchMe;
	
	private final Wait<WebDriver> wait;

	public PageObjectFindByGoogle(WebDriver driver){
		this.driver = driver;
		driver.get("http://www.google.com/");
		wait = new WebDriverWait(driver,10);
	}
	
	public void search(String text) throws Exception{
		searchMe.sendKeys(text);
		submitMe.submit();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)) );
		wait.until(ExpectedConditions.titleContains(text));
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
	
}
