package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
/*
REQUIRED BROWSER CONFIGURATION FOR IE
https://github.com/seleniumhq/selenium-google-code-issue-archive#Required_Configuration

With help of:
https://www.guru99.com/desired-capabilities-selenium.html
*/
public class MultipleDriversTest {
	
	private static WebDriver driver;
	private static int timeOutInSec = 15;

	@Test
	public void testTitlePageFirefox() {
        browserChoice(Drivers.FIREFOX);

        driver.get("https://www.google.pl/");
        
        assertEquals("Google", driver.getTitle());
    }
    
    @Test
	public void testTitlePageChromium() {
        browserChoice(Drivers.CHROMIUM);

        driver.get("https://www.google.pl/");
        
        assertEquals("Google", driver.getTitle());
	}

    @Test
	public void testTitlePageIE() {
        browserChoice(Drivers.IE);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        assertEquals("Google", driver.getTitle());
    }
    
    // @Test
	// public void testTitlePageOpera() {
    //     browserChoice(Drivers.OPERA);

    //     driver.get("https://www.google.pl/");
        
    //     assertEquals("Google", driver.getTitle());
    // }

    private static void browserChoice(Drivers driverName){
        switch (driverName) {
            case FIREFOX:{
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(timeOutInSec, TimeUnit.SECONDS);
                break;
            }
            
            case IE:{
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
                WebDriver driver = new InternetExplorerDriver(capabilities);

                //driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(timeOutInSec, TimeUnit.SECONDS);
                break;
            }

            case CHROMIUM: {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/usr/bin/chromium-browser");
                driver = new ChromeDriver(options);
            }
            
            
            // case OPERA:{
            //     System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
            //     System.setProperty("opera.binary", "C:\"\"Program Files\"Opera\"launcher.exe");
            //     driver = new OperaDriver();
            //     driver.manage().timeouts().implicitlyWait(timeOutInSec, TimeUnit.SECONDS);
            //     break;
            // }

            default: break;
        }
    }

    	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}
}


enum Drivers{
    IE,
    // OPERA,
    FIREFOX,
    CHROMIUM
}
