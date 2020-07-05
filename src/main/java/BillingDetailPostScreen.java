import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingDetailPostScreen extends GeneralPage{
    public BillingDetailPostScreen(WebDriver driver) {
        super(driver);
    }

    private By errorText = By.xpath("//td[@class='messageCell']/div");
    private By postButton = By.xpath("(//input[@value='Post'])[1]");

    public String getErrorMessage (){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorText));
        return driver.findElement(errorText).getText();
    }

    public BillingDetailPage clickPostBilling(){
        wait.until(ExpectedConditions.presenceOfElementLocated(postButton));
        driver.findElement(postButton).click();
        return new BillingDetailPage(driver);
    }
}
