import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    private By allTabs = By.xpath("//*[@id='AllTab_Tab']/a");

    public AllTabsPage clickAllTabs(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabs));
        driver.findElement(allTabs).click();
        return new AllTabsPage(driver);
    }
}
