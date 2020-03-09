import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTabsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AllTabsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    private By allTabsHeader = By.xpath("//h1[text()='All Tabs']");
    private By billingsLink = By.xpath("//a[text()='Billings']");

    public String getAllTabsHeader(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabsHeader));
        return driver.findElement(allTabsHeader).getText();
    }

    public BillingList openBillingPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabsHeader));
        driver.findElement(billingsLink).click();
        return new BillingList(driver);
    }
}
