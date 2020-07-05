import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewBillingLineScreen extends GeneralPage{
    public NewBillingLineScreen(WebDriver driver) {
        super(driver);
    }
    private By unitPrice = By.xpath("//label[text()='Unit Price']/../../following-sibling::td[1]//input");
    private By saveButton = By.xpath("(//input[@value=' Save '])[1]");

    public void enterUnitPrice(String value){
        wait.until(ExpectedConditions.presenceOfElementLocated(unitPrice));
        driver.findElement(unitPrice).sendKeys(value);
    }

    public BillingLineScreen clickSaveButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
        return new BillingLineScreen(driver);
    }



}
