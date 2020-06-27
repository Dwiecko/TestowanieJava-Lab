package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectSearch {
	
	public WebDriver driver;
	private final Wait<WebDriver> wait;

	public PageObjectSearch(WebDriver driver){
		this.driver = driver;
		driver.get("https://www.wp.pl/");
		wait = new WebDriverWait(driver,10);
	}
	
	public void search() throws Exception{
		driver.findElement(By.id("q")).sendKeys("poczta");
        driver.findElement(By.id("Password")).sendKeys("Test!23");
        driver.findElement(By.xpath("//div[5]/button")).click();
		System.out.println("Pomyślnie zalogowano");
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Budget Application");
		System.out.println(driver.getTitle());
		return(result);
	}
	
}
