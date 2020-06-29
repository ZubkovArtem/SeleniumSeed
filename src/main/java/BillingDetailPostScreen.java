import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingDetailPostScreen extends GeneralPage{
    public BillingDetailPostScreen(WebDriver driver) {
        super(driver);
    }

    public By errorText = By.xpath("//td[@class='messageCell']/div");

    public String getErrorMessage (){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorText));
        return driver.findElement(errorText).getText();
    }
}
