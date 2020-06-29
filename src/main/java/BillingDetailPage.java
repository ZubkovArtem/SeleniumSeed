import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingDetailPage extends GeneralPage{

    public BillingDetailPage(WebDriver driver) {
        super(driver);
    }

    private By postingStatus = By.xpath("//table[@class='detailList']//span[text()='Posting Status']/../following-sibling::td[1]/div");
    private By postButton = By.xpath("//div[@class='pbHeader']//td[@id='topButtonRow']/input[@class='btn'][@title='Post']");

    public String getPostingStatusAfter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(postingStatus));
        return driver.findElement(postingStatus).getText();
    }

    public BillingDetailPostScreen clickPostButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(postButton));
        driver.findElement(postButton).click();
        return new BillingDetailPostScreen(driver);
    }

}
