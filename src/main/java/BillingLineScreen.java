import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingLineScreen extends GeneralPage{
    public BillingLineScreen(WebDriver driver) {
        super(driver);
    }

    private By billingLink = By.xpath("//span[text()='Billing']/../following-sibling::td[1]//a");

    public BillingDetailPage clickBillingLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(billingLink));
        driver.findElement(billingLink).click();
        return new BillingDetailPage(driver);
    }


}
