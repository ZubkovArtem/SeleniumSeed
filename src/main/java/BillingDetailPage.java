import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingDetailPage extends GeneralPage{

    public BillingDetailPage(WebDriver driver) {
        super(driver);
    }

    private By postingStatus = By.xpath("//table[@class='detailList']//span[text()='Posting Status']/../following-sibling::td[1]/div");

    public String getPostingStatusAfter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(postingStatus));
        return driver.findElement(postingStatus).getText();
    }

}
