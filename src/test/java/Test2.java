import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    private WebDriver driver;
    private LoginPage login;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        login = new LoginPage(driver);
    }
    @Test
    public void runTest2(){
        GeneralPage home = login.clickLogInButton("ac.qa.mc.houston@as.com", "Ac)qa(houston123");
        AllTabsPage allTabs = home.clickAllTabs();
        BillingList billingPage = allTabs.openBillingPage();
        billingPage.closeLexTryPopUp();
        BillingNewPage billingNewPage = billingPage.clickNewButton();
        BillingDetailPage billingDetail = billingNewPage.createBilling("Mike");
        BillingDetailPostScreen billingDetailPostScreen = billingDetail.clickPostButton();
        String postErrorActual = billingDetailPostScreen.getErrorMessage();
        String postErrorExpected = "Error:\n" +"There are no billing lines to post for the record(s)";
        Assert.assertEquals(postErrorActual,postErrorExpected);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
