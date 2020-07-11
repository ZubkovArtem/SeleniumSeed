import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    private WebDriver driver;
    private LoginPage login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Артем\\Dropbox\\SeleniumSeed\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        login = new LoginPage(driver);
    }

    @Test
    public void runTest3() {
        GeneralPage home = login.clickLogInButton("ac.qa.mc.houston@as.com", "Ac)qa(houston123");
        AllTabsPage allTabs = home.clickAllTabs();
        BillingList billingPage = allTabs.openBillingPage();
        billingPage.closeLexTryPopUp();
        BillingNewPage billingNewPage = billingPage.clickNewButton();
        BillingDetailPage billingDetail = billingNewPage.createBilling("Mike");
        NewBillingLineScreen newBillingLineScreen = billingDetail.clickNewBillingLine();
        newBillingLineScreen.enterUnitPrice("1234");
        BillingLineScreen billingLineScreen = newBillingLineScreen.clickSaveButton();
        BillingDetailPage billingDetailPage = billingLineScreen.clickBillingLink();
        BillingDetailPostScreen billingDetailPostScreen = billingDetailPage.clickPostButton();
        billingDetailPage = billingDetailPostScreen.clickPostBilling();
        billingDetailPage.clickPostButton();
        String postErrorActual = billingDetailPostScreen.getErrorMessage();
        String postErrorExpected = "The record has already been posted.";
        Assert.assertEquals(postErrorActual,postErrorExpected);
        //awdawd
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}