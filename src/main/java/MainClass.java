import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\avzub\\Dropbox\\SeleniumSeed\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");

        LoginPage login = new LoginPage(driver);
        //LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.enterUsername("ac.uat.mc.houston@asqa.com");
        login.enterPassword("houston123");
        //Test
//        HomePage home = login.clickLogInButton();
//        HomePage home = new HomePage(driver);
//        System.out.println(home.getHomeText());
    }
}
