import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingList extends GeneralPage{

    public BillingList(WebDriver driver) {
        super(driver);
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
