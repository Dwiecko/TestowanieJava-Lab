

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class GoogleHtmlUnitTest {
	
	@Test
	public void testTitlePage(HtmlUnitDriver driver) {
		driver.get("https://duckduckgo.com/");
    	assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
	}
	
	@Test
	public void testClick(HtmlUnitDriver driver){
		driver.get("https://duckduckgo.com/");
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
	
}
