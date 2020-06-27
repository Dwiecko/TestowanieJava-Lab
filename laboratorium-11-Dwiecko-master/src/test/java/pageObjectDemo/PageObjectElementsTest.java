//  // /Account/Login
 package pageObjectDemo;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectElementsTest {
	
	private static WebDriver driver;
	private final String baseURLTextFields = "https://login.aliexpress.com/join/buyer/expressJoin.htm";
	private final String budgetURL = "http://budgetapplication20180122102533.azurewebsites.net/Account/Login";

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void getTextElemets() throws Exception{
		driver.get(baseURLTextFields);
		java.util.List<WebElement> textboxes = driver.findElements(By.xpath("//input[@type='text']"));
		java.util.List<WebElement> textAndPasswordBoxes = driver.findElements(By.xpath("//input[@type='text' or @type='password']")); 
		java.util.List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println("Ilosc pol tekstowych: "+ textboxes.size());
		System.out.println("Ilosc pol tekstowych i z haslem: "+ textAndPasswordBoxes.size());
		System.out.println("Ilosc pol do wyboru: "+ checkBoxes.size());
	}

	//REASON OF USING TWO DRIVERS:
	//The element reference of <a href="/"> is stale; either the element is no longer attached to the DOM, it is not in the current frame context,
	///or the document has been refreshed
	@Test
	public void findLinks() throws Exception{
        driver.get(budgetURL);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		WebDriver tempDriver = new FirefoxDriver();
		// System.out.println("Liczba linkow: "+ links.size());
		// for (WebElement element : links) {
		// 	System.out.println("Nazwa: "+element.getText()+ " || Adres: "+ element.getAttribute("href"));
		// }

		for (WebElement element : links) {
			tempDriver.get(element.getAttribute("href"));
			//linksHttp.add(element.getAttribute("href"));
		}

		//List<String> linksHttp = new ArrayList<String>();	
        // for (String link : linksHttp) {
		// 	driver.get(link);
		// 	//	driver.navigate().back(); 
        // }		
	}
	
	@Test
	public void getGooglePartialLinks()
	{
		driver.get("https://google.pl");
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement webElement : elements) {
			if(webElement.getAttribute("href").contains("google") && webElement.isDisplayed())
			{
				driver.get(webElement.getAttribute("href"));
			}
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}

