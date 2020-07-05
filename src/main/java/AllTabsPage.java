import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllTabsPage extends GeneralPage{

    public AllTabsPage(WebDriver driver) {
        super(driver);
    }

    private By allTabsHeader = By.xpath("//h1[text()='All Tabs']");
    private By billingsLink = By.xpath("//a[text()='Billings']");

    public BillingList openBillingPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(allTabsHeader));
        driver.findElement(billingsLink).click();
        return new BillingList(driver);
    }
}
