import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

//    @FindBy (xpath = "//input[@id='Login']")
//    private WebElement logInButton;

    private By logInButton = By.xpath("//input[@id='Login']");
    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");

    public LoginPage enterUsername (String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public HomePage clickLogInButton(String username, String password){
        this.enterUsername(username);
        this.enterPassword(password);
        driver.findElement(logInButton).click();
        return new HomePage(driver);
    }
}
