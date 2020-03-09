import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingList {
    private WebDriver driver;
    private WebDriverWait wait;

    public BillingList(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }
    private By lexTryPopUp = By.xpath("//div[@id='tryLexDialog']/div//a[@class='dialogClose']");
    private By newButton = By.xpath("//input[@class='btn'][@title='New']");


    public void closeLexTryPopUp(){
        wait.until(ExpectedConditions.presenceOfElementLocated(lexTryPopUp));
        driver.findElement(lexTryPopUp).click();
    }
    public BillingNewPage clickNewButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(newButton));
        driver.findElement(newButton).click();
        return new BillingNewPage(driver);
    }


}
