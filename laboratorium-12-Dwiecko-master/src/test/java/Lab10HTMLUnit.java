

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class Lab10HTMLUnit {
   
	@Test	
	public void login(HtmlUnitDriver driver) throws Exception{
        PageObjectLogin loginSite = new PageObjectLogin(driver);

        String message =  loginSite.login();

	    assertEquals("Pomyślnie zalogowano", message);
    }
    
	@Test
	public void assertTitle(HtmlUnitDriver driver) throws Exception{
        PageObjectLogin loginSite = new PageObjectLogin(driver);

        boolean titleIsCorrect = loginSite.assertTitle();
        
        assertTrue(titleIsCorrect);
    }
	
}
