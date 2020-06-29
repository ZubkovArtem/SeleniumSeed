import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    private By allTabs = By.xpath("//*[@id='AllTab_Tab']/a");

    public AllTabsPage clickAllTabs(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabs));
        driver.findElement(allTabs).click();
        return new AllTabsPage(driver);
    }
}
