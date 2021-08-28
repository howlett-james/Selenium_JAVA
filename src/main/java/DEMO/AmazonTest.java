package DEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AmazonTest {
    WebDriver driver;
    @Parameters("browser")
    @BeforeTest
    public void getBaseUrl(String browser) throws InterruptedException {
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
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);
    }
    @Test
    public void amazontest(){
        driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kuttyyokesh1221@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Yokesh@210899",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("motorola razr",Keys.ENTER);
        driver.findElement(By.xpath("//span[starts-with(text(),'Motorola Razr')]")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Deliver to this address')]")).click();
        driver.switchTo().window(tabs.get(0));
        driver.navigate().refresh();
        String cartCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        for(int i=1;i<=Integer.parseInt(cartCount);i++){
            driver.findElement(By.xpath("//input[@value='Delete' and @data-item-count="+i+"]")).click();
        }
    }
    @AfterTest
    public void TearDown(){
        driver.quit();
    }
}
