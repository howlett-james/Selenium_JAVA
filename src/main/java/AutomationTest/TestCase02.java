package AutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase02 {
    WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void getBaseUrl(String browser)throws Exception {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    ".\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver",
                    ".\\Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void TestCaseTwo(){
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("seleniumtest02@gmail.com");
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("681654");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("3184518");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("saf51844");
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("21415878");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("589154");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("4894155474/7");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("219848978");
        WebElement s =driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select = new Select(s);
        select.selectByVisibleText("Alaska");
        WebElement d =driver.findElement(By.xpath("//input[@name='postcode']"));
        d.click();
        d.sendKeys("DFASD");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("skjfhsdkjh");
        driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("694584");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
