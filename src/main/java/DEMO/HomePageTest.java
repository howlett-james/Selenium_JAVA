package DEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    WebDriver driver;
    @BeforeTest
    public void getBaseUrl(){
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.flipkart.com");
    }
    @Test(priority = 1)
    public void VerifyTitle(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
    }
    @Test(priority = 2)
    public void Login(){
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("test@gmail.com",Keys.TAB);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
    }
    @Test(priority = 3)
    public void CloseLogin(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }
    @AfterTest
    public void TearDown(){
        driver.quit();
    }
}
