

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class GoogleFluentWaitTest {
	
	/* Metoda FluentWait() jest bardzo podobna do ocekiwania jawnego. 
	 * Sprawdza co ustalony interwal czasu, czy dany element się pojawił. 
	 * Różnica z oczekiwaniem jawnym polega na ignorowaniu wyjątków.
	 */
	
	
    //private ChromeDriver driver;
    private FirefoxDriver driver;

	public GoogleFluentWaitTest(FirefoxDriver driver) {
		this.driver = driver;
	}
	
	@BeforeEach
	public void setDefaultPage() {
		driver.get("https://duckduckgo.com/");
	}

	@Test
	public void testTitlePage() {
    	assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
	}
	
	@Test
	public void testClick(){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_form_input_homepage")));
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk at DuckDuckGo"));
		assertEquals("Mateusz Miotk at DuckDuckGo",driver.getTitle());
	}
	
	@Test
	public void testClick2(){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk at DuckDuckGo"));
		assertEquals("Mateusz Miotk at DuckDuckGo",driver.getTitle());
	}
	
}
