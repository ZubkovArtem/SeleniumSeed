import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    private WebDriver driver;
    private LoginPage login;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Артем\\Dropbox\\SeleniumSeed\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        login = new LoginPage(driver);
    }
    @Test
    public void runTest1(){
        GeneralPage home = login.clickLogInButton("ac.qa.mc.houston@as.com", "Ac)qa(houston123");
        AllTabsPage allTabs = home.clickAllTabs();
        BillingList billingPage = allTabs.openBillingPage();
        billingPage.closeLexTryPopUp();
        BillingNewPage billingNewPage = billingPage.clickNewButton();
        String postingStatus1 = billingNewPage.getPostingStatusBefore();
        BillingDetailPage billingDetail = billingNewPage.createBilling("Mike");
        String postingStatus2 = billingDetail.getPostingStatusAfter();
        System.out.println("postingStatus1 = " + postingStatus1);
        System.out.println("postingStatus2 = " + postingStatus2);
        Assert.assertEquals(postingStatus1,postingStatus2);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
