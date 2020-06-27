package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement Email;

    @CacheLookup
    @FindBy(id = "passwd")
    private WebElement Password;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    private WebElement LoginButton;

    private String LoginTitle;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        LoginTitle = setTitle();
    }

    public String getEmail() {
        return Email.getText();
    }

    public String getTitle() {
        return LoginTitle;
    }

    public void setPassword(String givenPassword) {
        Password.sendKeys(givenPassword);
    }

    public void setEmail(String givenEmail) {
        Email.sendKeys(givenEmail);
    }

    public String setTitle() {
        return driver.getTitle();
    }

    public void login(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);

        LoginButton.click();
    }

    public boolean assertTitle() throws Exception{
        Boolean result = driver.getTitle().contains("My account - My Store");

        return result;
    }

}


