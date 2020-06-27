 // /Account/Login

 package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectLoginTest {
	
	private static WebDriver driver;
	public PageObjectLogin loginPage;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void logIn() throws Exception {
		loginPage = new PageObjectLogin(driver);
		loginPage.login();
		assertTrue(loginPage.assertTitle());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
