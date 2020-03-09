import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingDetailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BillingDetailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    private By postingStatus = By.xpath("//*[@id=\"00N3i000007rBOx_ileinner\"]");

    public String getPostingStatusAfter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(postingStatus));
        return driver.findElement(postingStatus).getText();
    }

}
