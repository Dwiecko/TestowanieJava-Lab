import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class Lab10PhantomJSTest {
    private PhantomJSDriver driver;
    private PageObjectLogin pageObject;

	public Lab10PhantomJSTest(PhantomJSDriver phantomDriver) {
        driver = phantomDriver;
        pageObject = new PageObjectLogin(driver);
    }

    @Test	
	public void login() throws Exception {
        String message =  pageObject.login();
        
        assertEquals("Pomyślnie zalogowano", message);
    }
    
	@Test
	public void assertTitle() throws Exception {
		boolean titleIsCorrect = pageObject.assertTitle();
        assertTrue(titleIsCorrect);
    }
}