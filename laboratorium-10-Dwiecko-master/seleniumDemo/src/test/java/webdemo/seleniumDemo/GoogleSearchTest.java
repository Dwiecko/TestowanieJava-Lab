package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GoogleSearchTest {
	
	private static WebDriver driver;
	private WebDriverWait wait;
	private static int timeOutInSec = 10;
	
	@BeforeAll
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(timeOutInSec, TimeUnit.SECONDS);
	}

	@Test
	public void testTitlePage() {
		driver.get("https://www.google.pl/");
    	assertEquals("Google", driver.getTitle());
	}

	@Test
	public void browserTestResultFoundAndClick()
	{
		 wait = new WebDriverWait(driver, timeOutInSec);
		driver.get("https://www.google.pl/");
		driver.findElement(By.id("lst-ib")).sendKeys("github");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.titleIs("github - Szukaj w Google"));
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));		
		findElements.get(0).click();
		
		assertEquals(driver.getCurrentUrl(), "https://github.com/");
	}

	@Test
	public void listIsEmpty()
	{
		wait = new WebDriverWait(driver, timeOutInSec);
		driver.get("https://www.google.pl/");
		driver.findElement(By.id("lst-ib")).sendKeys("sdkfsmddddddddddddddddddddddddddddddddddddddddddd");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.titleIs("sdkfsmddddddddddddddddddddddddddddddddddddddddddd - Szukaj w Google"));
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));		
		
		assertEquals(0, findElements.size());
	}

	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
