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

    private By homeHeader = By.xpath("//h2[text()='Getting Started']");
    private By allTabs = By.xpath("//*[@id='AllTab_Tab']/a");

    public String getHomeText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homeHeader));
        return driver.findElement(homeHeader).getText();
    }

    public AllTabsPage clickAllTabs(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabs));
        driver.findElement(allTabs).click();
        return new AllTabsPage(driver);
    }
}
